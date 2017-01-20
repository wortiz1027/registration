package co.com.registration.application.service.dao;

import java.util.List;

import co.com.registration.application.model.Role;

public interface RoleServicesDao {
	
	public List<Role> getAllRoles();
	
	public Role getInfoRole();
	
	public void deleteRole();
	
	public void updateRole();
	
}