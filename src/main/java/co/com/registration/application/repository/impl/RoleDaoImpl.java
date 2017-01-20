package co.com.registration.application.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.registration.application.model.Role;
import co.com.registration.application.repository.dao.RoleDao;
import co.com.registration.application.repository.generic.GenericDAOImpl;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends GenericDAOImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public List<Role> getRoleListNq() {
		
		StringBuilder sQuery = new StringBuilder();
		
		sQuery.append("SELECT r");
		sQuery.append("FROM ");
		sQuery.append(getClazz().getSimpleName());
		sQuery.append("r");
		
		Query query = getSessionFactory().getCurrentSession().createQuery(sQuery.toString()); 
		
		List<Role> roles = new ArrayList<Role>();
		
		for (Object object : query.list()){
			 if (object instanceof Role){
				 roles.add((Role)object);
			 }
		}
		
		return roles;
	}	
	
}