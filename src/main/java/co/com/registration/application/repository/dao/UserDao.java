package co.com.registration.application.repository.dao;

import co.com.registration.application.model.User;
import co.com.registration.application.repository.generic.GenericDAO;

public interface UserDao extends GenericDAO<User, Long> {
	
	public boolean isUserAvailable(String login);
	
	public User loadUserByUsername(String username);
	
}