package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Stuudent;

public class HQLDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		//HQL
		//Syntax
		Session session = factory.openSession();
//String query = "from Stuudent";
		//		String query = "from Stuudent where city='Noida'";
		String query = "from Stuudent where city=:x";
		
		Query q =session.createQuery(query);
		q.setParameter("x", "Noida");
		//single result (unique) 
		//or multiple result ---list    q.uniqueResult();
		List<Stuudent> list = q.list();
		
		for(Stuudent std : list) {
			System.out.println(std.getName()+" : " + std.getCerti().getCourse());
		}
		System.out.println("-----------------------------------");
		Transaction tx = session.beginTransaction();
		//delete query
//		Query q1 = session.createQuery("delete from Stuudent where city =:c");
//		q1.setParameter("c", "mumbai");
//		int r = q1.executeUpdate();
//		System.out.println("Deleted : "+r);
//		tx.commit();
		//update query
		Query q1 = session.createQuery("update Stuudent set city=:c where id=:i");
		q1.setParameter("c", "Gurugram");
		q1.setParameter("i", 125);
		int r = q1.executeUpdate();
		System.out.println("updated : "+r);
		tx.commit();
		
		//how to execute join query
		Query q2 = session.createQuery("select q.questionId,q.question,a.answer from Question q INNER JOIN q.answer a");
		List<Object[]> list3 = q2.list();
		for(Object[] arr :list3) {
			System.out.println(Arrays.toString(arr));
		}
		
		factory.close();
	}
}
