package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Stuudent;

public class FirstLevelDemo {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session session = factory.openSession();
		 //by default enabled
		 Stuudent student = session.get(Stuudent.class, 123);
		 System.out.println(student);
		 
		 System.out.println("Working something");
		 Stuudent student1 = session.get(Stuudent.class, 123);
		 System.out.println(student1);
		 System.out.println(session.contains(student1));
		 
		 
		 session.close();
		
		 factory.close();
	}
}
