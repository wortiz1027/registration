package co.com.registration.application.service.dao;

import java.math.BigDecimal;
import java.util.List;

import co.com.registration.application.model.OauthClientDetails;

public interface ClientServicesDao {
	
	public List<OauthClientDetails> getallClient();
	
	public void createClient(OauthClientDetails client);
	
	public boolean isClientAvailable(String clientId);
	
	public OauthClientDetails getClientById(String clientId);
	
	public OauthClientDetails getClientByOauth2Id(BigDecimal oid);
	
	public OauthClientDetails actualizar(OauthClientDetails client);
	
	public void eliminar(OauthClientDetails client);
	
	public void eliminar(BigDecimal oid);
	
	public void eliminar(String clientId);
	
}