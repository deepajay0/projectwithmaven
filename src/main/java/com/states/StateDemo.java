package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Stuudent;

public class StateDemo {
	public static void main(String[] args) {
		System.out.println("example");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		//creating student object
		Stuudent student = new Stuudent();
		student.setId(123);
		student.setName("Peter");
		student.setCity("Noida");
		student.setCerti(new Certificate("java Hibernate","2 months"));
		//student: Transient
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(student);
		student.setName("John");
		//student : Persistent -- session,database
		tx.commit();
		
		s.close();
		factory.close();
	}
}
