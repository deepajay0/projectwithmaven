package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Stuudent;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Criteria c = s.createCriteria(Stuudent.class);
//		c.add(Restrictions.eq("city", "Noida"));
		c.add(Restrictions.ge("id", 127));
		
		
		
		List<Stuudent> list = c.list();
		for(Stuudent std : list) {
			System.out.println(std);
		}
		s.close();
		factory.close();
	}
}
