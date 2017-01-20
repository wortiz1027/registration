package co.com.registration.application.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import co.com.registration.application.annotation.InfoLogger;
import co.com.registration.application.model.OauthClientDetails;
import co.com.registration.application.service.dao.ClientServicesDao;
import co.com.registration.application.util.Utils;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	
	@Autowired
	ClientServicesDao clientService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@RequestMapping(value = { "/", "/list" }, 
			        method = RequestMethod.GET)
	public String listClient(ModelMap model) {

		List<OauthClientDetails> clients = clientService.getallClient();
		model.addAttribute("oauthClientDetails", clients);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "clientlist";
	}
	
	@RequestMapping(value = { "/newclient" }, 
			        method = RequestMethod.GET)
	public String newClient(ModelMap model) {
		
		OauthClientDetails oauthClientDetails = new OauthClientDetails();
		model.addAttribute("oauthClientDetails", oauthClientDetails);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "clientregistration";
	}
	
	@RequestMapping(value = { "/newclient" }, 
			        method = RequestMethod.POST)
	@InfoLogger(source = "saveClient")
	public String saveClient(@Valid OauthClientDetails oauthClientDetails, 
			                        BindingResult result,
			                        ModelMap model) {

		if(clientService.isClientAvailable(oauthClientDetails.getClientId())){
			FieldError clientError = new FieldError("client",
					                                "clientId",
					                                messageSource.getMessage("non.unique.clientId", 
					                                		                 new String[]{
					                                									  oauthClientDetails.getClientId()
					                                		                              }, 
					                                		                 Locale.getDefault()));
		    result.addError(clientError);
			return "clientregistration";
		}
		
		oauthClientDetails.setClientId(Utils.generateClientInformation(oauthClientDetails.getClientId()));
		oauthClientDetails.setClientSecret(Utils.generateClientSecret(oauthClientDetails.getClientName()));
		
		clientService.createClient(oauthClientDetails);
		
		model.addAttribute("newClient", oauthClientDetails);		
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/edit-client-{oid}" }, method = RequestMethod.GET)
	public String editClient(@PathVariable BigDecimal oid, ModelMap model) {
		
		OauthClientDetails oauthClientDetails = clientService.getClientByOauth2Id(oid);
		model.addAttribute("oauthClientDetails", oauthClientDetails);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "clientregistration";
	}
	
	@RequestMapping(value = { "/edit-client-{oid}" }, method = RequestMethod.POST)
	public String updateclient(@Valid OauthClientDetails oauthClientDetails, 
				                      BindingResult result,
				                      ModelMap model, 
				               @PathVariable BigDecimal oid) {

		if (result.hasErrors()) {
			return "clientregistration";
		}

		clientService.actualizar(oauthClientDetails);

		model.addAttribute("oauthClientDetails", oauthClientDetails);		
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/delete-client-{oid}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable BigDecimal oid) {
		clientService.eliminar(oid);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessdenied";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
 
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
     
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    
}