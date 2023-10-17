package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Stuudent std1 = new Stuudent();
		 std1.setId(14134);
		 std1.setName("ajay deep");
		 std1.setCity("chandauli");
		 Certificate certi = new Certificate();
		 certi.setCourse("Java");
		 certi.setDuration("2 months");
		 
		 std1.setCerti(certi);
		 
		 Stuudent std2 = new Stuudent();
		 std2.setId(14140);
		 std2.setName("aman");
		 std2.setCity("chandauli");
		 Certificate certi1 = new Certificate();
		 certi1.setCourse("Android");
		 certi1.setDuration("2 months");
		 
		 std2.setCerti(certi1);
		 Session s = factory.openSession();
		 Transaction tx = s.beginTransaction();
		 s.save(std1);
		 s.save(std2);
		 tx.commit();
	
	
		 factory.close();
	}
}
