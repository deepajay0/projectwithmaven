package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session session = factory.openSession();
		 Stuudent student = (Stuudent)session.load(Stuudent.class, 102);
		 System.out.println(student.getId());
		 Stuudent student1 = (Stuudent)session.load(Stuudent.class, 102);
		 System.out.println(student1.getId());
//		 Address address = (Address)session.load(Address.class, 101);
//		 System.out.println(address.getAddressId());
		 
		 
		 session.close();
		 factory.close();
	}
}
