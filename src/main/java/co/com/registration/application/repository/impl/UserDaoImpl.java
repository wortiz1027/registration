package co.com.registration.application.repository.impl;

import javax.persistence.NoResultException;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import co.com.registration.application.annotation.InfoLogger;
import co.com.registration.application.model.User;
import co.com.registration.application.repository.dao.UserDao;
import co.com.registration.application.repository.generic.GenericDAOImpl;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends GenericDAOImpl<User, Long> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public boolean isUserAvailable(String login) {
		Assert.notNull(login);
		
		StringBuilder sQuery = new StringBuilder();
		
		sQuery.append("SELECT count(*) \n");
		sQuery.append("FROM ");
		sQuery.append(getClazz().getSimpleName());
		sQuery.append(" u \n");
		sQuery.append("WHERE u.login = :ipLogin");
		
		Query query = getSessionFactory().getCurrentSession().createQuery(sQuery.toString());
		query.setParameter("ipLogin", login);
		
		Long count = (Long) query.list().get(0);
		
		return count < 1;
	}

	@Override
	@InfoLogger(source = "loadUserByUsername")
	public User loadUserByUsername(String username) {
		Assert.notNull(username);
		
		User user = null;
		
		StringBuilder sQuery = new StringBuilder();
		
		sQuery.append("SELECT u \n");
		sQuery.append("FROM ");
		sQuery.append(getClazz().getSimpleName());
		sQuery.append(" u \n");
		sQuery.append("WHERE u.login = :ipLogin");
		
		try{
			
			user = (User) getSessionFactory()
				                    .getCurrentSession()
				                    .createQuery(sQuery.toString())
				                    .setParameter("ipLogin", username)
				                    .list().get(0);
			
		}catch (NoResultException nre){
				 System.out.println("No se encontro el usuario --> " + nre.toString());
		}
		
		return user;
	}

}