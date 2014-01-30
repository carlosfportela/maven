package dao;

import model.Pessoa;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoFactory {
	
	private final Session session;
	private Transaction transaction;
	
	public DaoFactory(Session sessao) {
		session = sessao;
	}
	
	public void beginTransaction() {
		this.transaction = this.session.beginTransaction();
	}
	
	public void commit() {
		this.transaction.commit();
		this.transaction = null;
	}
	
	public boolean hasTransaction() {
		return this.transaction != null;
	}
	
	public void rollback() {
		this.transaction.rollback();
		this.transaction = null;
	}
	
	public void flush() {
		this.session.flush();
	}
	
	public void close() {
		this.session.close();
	}
	
	public Dao<Pessoa> getPessoaDao() {
		return new Dao<Pessoa>(this.session, Pessoa.class);
	}

}
