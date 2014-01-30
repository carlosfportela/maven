package jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import model.GenericModel;

public interface Repositorio <T extends GenericModel, ID extends Serializable>{
	
	public Long count() throws Exception;
	public void save(T entity) throws Exception;
	public T find(Map<String, Object> map);
	public T find(long id);
	public List<T> findAll(Map<String, Object> map);
	public List<T> findAll();
	public void update(T entity) throws Exception;

}
