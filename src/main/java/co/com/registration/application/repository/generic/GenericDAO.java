package co.com.registration.application.repository.generic;

import java.util.List;

public interface GenericDAO<T, ID extends java.io.Serializable> {
	
	public List<T> getAllRows();
	
	public T getById(ID id);
	
	public T save(T entity);
	
	public void delete(ID id);
	
	public void delete(T entity);
	
	public T update(T entity);
	
}