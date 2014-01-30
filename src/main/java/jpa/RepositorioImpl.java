package jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.GenericModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.EntityManagerImpl;



public class RepositorioImpl<T extends GenericModel, ID extends Serializable> implements Repositorio<T, ID>{
	
	@PersistenceContext
	private EntityManager manager;
	public final Class<T> clas;
	private static final String ACTIVE = "active";
	
	
	

	public RepositorioImpl() {
		this.clas = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}




	protected EntityManager getManager() {
		return manager;
	}
	
	protected org.hibernate.Session getSession() {
		return ((EntityManagerImpl)getManager().getDelegate()).getSession();
	}


	protected Class<T> getObjectClass() {
		return this.clas;
	}


	public Long count() throws Exception {
		Criteria c = getSession().createCriteria(getObjectClass());
		
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return (Long) c.setProjection(Projections.rowCount()).uniqueResult();
	}




	public void save(T entity) throws Exception {
		this.getManager().persist(entity);
		
	}




	public T find(Map<String, Object> map) {
		Criteria c = getSession().createCriteria(getObjectClass());
		
		for(String key : map.keySet())
			c.add(Restrictions.eq(key, map.get(key)));
		
		return (T) c.uniqueResult();
	}
	

	public T find (long id){
		return (T) this.getSession().load(getObjectClass(), id);
	}


	public List<T> findAll(Map<String, Object> map) {
		Criteria c = getSession().createCriteria(getObjectClass());
		
		for(String key : map.keySet())
			c.add(Restrictions.eq(key, map.get(key)));
		
		return (List<T>) c.list();

	}
	
	
	public List<T> findAll() {
		Criteria c = getSession().createCriteria(getObjectClass());
		
		return (List<T>) findAll(new HashMap<String, Object>());

	}




	public void update(T entity) throws Exception {
		this.getManager().merge(entity);
		
	}

	
}
