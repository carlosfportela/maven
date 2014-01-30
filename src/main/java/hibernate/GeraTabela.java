package hibernate;

import org.hibernate.Session;


import dao.DaoFactory;

public class GeraTabela {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		DaoFactory fac = new DaoFactory(session);
		
		System.out.println("Fim");
	}

}
