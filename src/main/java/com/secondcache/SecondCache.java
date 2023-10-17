package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.tut.Stuudent;

public class SecondCache {
	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session session = factory.openSession();
		 Stuudent std1 = session.get(Stuudent.class, 125);
		 System.out.println(std1);
		 
		 session.close();
		 Session session1 = factory.openSession();
		 Stuudent std2 = session1.get(Stuudent.class, 125);
		 System.out.println(std2);
		 session1.close();
		 factory.close();
	}
}
