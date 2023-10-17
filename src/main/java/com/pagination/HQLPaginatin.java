package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Stuudent;

public class HQLPaginatin {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query q = s.createQuery("from Stuudent", Stuudent.class);

		// implementing pagination using hibernate
		int count = 0;
	
			q.setFirstResult(count);
			q.setMaxResults(3);
			List<Stuudent> list = q.list();
		
			for (Stuudent st : list) {
				System.out.println(st.getId() + ": " + st.getName() + " : " + st.getCity());
			}
	
			
	

		s.close();
		factory.close();
	}
}
