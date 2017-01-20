package co.com.registration.application.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.registration.application.model.PersistentLogins;
import co.com.registration.application.repository.generic.GenericDAOImpl;

@Repository("customPersistentTokenRepository")
@Transactional
public class RememberMeDaoImpl extends GenericDAOImpl<PersistentLogins, Long> implements PersistentTokenRepository {

	public RememberMeDaoImpl() {
		super(PersistentLogins.class);
	}

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLogins login = new PersistentLogins();
		
		login.setUsername(token.getUsername());
		login.setSeries(token.getSeries());
		login.setToken(token.getTokenValue());
		login.setLastUsed(token.getDate());
		
		save(login);
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		PersistentLogins login = new PersistentLogins();
		
		login.setSeries(series);
		login.setToken(tokenValue);
		login.setLastUsed(lastUsed);
		
		update(login);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		
		StringBuffer sQuery = new StringBuffer();
		
		sQuery.append("SELECT p ");
		sQuery.append("FROM ");
		sQuery.append(getClazz().getSimpleName());
		sQuery.append(" p ");
		sQuery.append("WHERE p.series = :ipSeries");
		
		List<?> login = getSessionFactory().getCurrentSession()
	                                       .createQuery(sQuery.toString())
	                                       .setParameter("ipSeries", seriesId)
	                                       .list();
		
		if (login.size() > 0){
		
			return new PersistentRememberMeToken(((PersistentRememberMeToken) login.get(0)).getUsername(),
												 ((PersistentRememberMeToken) login.get(0)).getSeries(),
												 ((PersistentLogins) login.get(0)).getToken(),
			  									 ((PersistentLogins) login.get(0)).getLastUsed());
		}
		
		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(PersistentLogins.class);
        crit.add(Restrictions.eq("username", username));
        PersistentLogins login = (PersistentLogins) crit.uniqueResult();
        
        if (login != null) {
            delete(login);
        }
        
	}
	
}