package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class Dao<T> {
	
	protected final Session session;
	private final Class classe;
	
	Dao(Session session, Class classe) {
		this.session = session;
		this.classe = classe;
	}
	
	public void salvar(T u) {
		this.session.save(u);
	}
	
	public void salvarOuAtualizar(T u) {
		this.session.saveOrUpdate(u);
	}
	
	public void imergir(T u) {
		this.session.merge(u);
	}
	
	public void remover (T e){
		this.session.delete(e);
	}
	
	public T procurar (long id){
		return (T) this.session.load(this.classe, id);
	}
		
	public void atualizar (T e){
		this.session.update(e);
	}
	
	public List<T> listarTudo() {
		Criteria c = this.session.createCriteria(this.classe);
		c.addOrder(Order.asc("id"));
		return (List<T>)c.list();
	}
}
