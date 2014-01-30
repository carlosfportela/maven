package hibernate;

import model.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static SessionFactory factory;

	static {
		
		Configuration cfg = new Configuration();

		cfg.addAnnotatedClass(Pessoa.class);

		factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
	
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}

}
