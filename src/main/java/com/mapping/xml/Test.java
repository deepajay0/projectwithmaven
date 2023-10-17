package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Person p = new Person();
		p.setId(111);
		p.setName("Ajay");
		p.setAddress("chandauli");
		p.setPhone("8299594530");
		Transaction tx = s.beginTransaction();
		s.save(p);
		tx.commit();
		s.close();
		
		
		factory.close();
	}
}
