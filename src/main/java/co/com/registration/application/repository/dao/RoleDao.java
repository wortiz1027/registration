package co.com.registration.application.repository.dao;

import java.util.List;

import co.com.registration.application.model.Role;
import co.com.registration.application.repository.generic.GenericDAO;

public interface RoleDao extends GenericDAO<Role, Long> {
	
	public List<Role> getRoleListNq();
	
}