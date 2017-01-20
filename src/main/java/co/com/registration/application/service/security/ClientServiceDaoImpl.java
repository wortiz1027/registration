package co.com.registration.application.service.security;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.registration.application.model.OauthClientDetails;
import co.com.registration.application.repository.dao.OAuthClientDAO;
import co.com.registration.application.service.dao.ClientServicesDao;

@Service("clientServiceDao")
public class ClientServiceDaoImpl implements ClientServicesDao {
	
	@Autowired
	private OAuthClientDAO clientDao;
	
	@Override
	public List<OauthClientDetails> getallClient() {
		return clientDao.getAllRows();
	}
	
	@Override
	public void createClient(OauthClientDetails client) {
		clientDao.save(client);
	}

	@Override
	public boolean isClientAvailable(String clientId) {
		return clientDao.isClientAvailable(clientId);
	}

	@Override
	public OauthClientDetails getClientById(String clientId) {
		return clientDao.getById(clientId);
	}

	@Override
	public OauthClientDetails actualizar(OauthClientDetails client) {
		return clientDao.update(client);
	}

	@Override
	public void eliminar(OauthClientDetails client) {
		clientDao.delete(client);
	}
	
	@Override
	public void eliminar(String clientId) {
		clientDao.delete(clientId);
	}

	@Override
	public OauthClientDetails getClientByOauth2Id(BigDecimal oid) {
		return clientDao.getByOauth2Id(oid);
	}

	@Override
	public void eliminar(BigDecimal oid) {
		clientDao.eliminarById(oid);
	}
	
}