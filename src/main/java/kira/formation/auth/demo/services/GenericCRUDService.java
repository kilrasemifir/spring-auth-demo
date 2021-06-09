package kira.formation.auth.demo.services;

import java.util.List;

public interface GenericCRUDService<T> {
	
	public T findById(String id);
	public List<T> findAll();
	public T save(T entity);
	void deleteById(String id);
}
