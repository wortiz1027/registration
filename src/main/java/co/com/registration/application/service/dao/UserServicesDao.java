package co.com.registration.application.service.dao;

import java.util.List;

import co.com.registration.application.model.Role;
import co.com.registration.application.model.User;

public interface UserServicesDao {
	
	public void createUser(User u, List<Role> role);
	
	public boolean isUserAvailable(String username);
	
	public User getUserByLogin(String login);
	
	public User actualizar(User u);
	
	public void eliminar(User u);
	
}