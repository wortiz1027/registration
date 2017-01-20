package co.com.registration.application.repository.dao;

import java.math.BigDecimal;

import co.com.registration.application.model.OauthClientDetails;
import co.com.registration.application.repository.generic.GenericDAO;

public interface OAuthClientDAO  extends GenericDAO<OauthClientDetails, String>{
	
	public boolean isClientAvailable(String clientId);
	public OauthClientDetails getByOauth2Id(BigDecimal oid);
	public OauthClientDetails loadClientByName(String clientName);
	public void eliminarById(BigDecimal oauth2Id);
	
}