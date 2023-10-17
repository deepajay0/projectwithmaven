package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Stuudent;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		String query = "select * from stuudent";
		NativeQuery nq = s.createSQLQuery(query);
		
		List<Object[]> list=nq.list();
		for(Object[] student : list) {
			System.out.println(student[4]+" "+student[3]);
		}
		
		
		s.close();
		factory.close();
	}
}
