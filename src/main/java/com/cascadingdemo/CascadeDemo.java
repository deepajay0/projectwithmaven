package com.cascadingdemo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.onetomany.Answer;
import com.mapping.onetomany.Question;



public class CascadeDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(567);
		q1.setQuestion("what is cascading");
		
		Answer a1 = new Answer(123,"first answer");
		Answer a2 = new Answer(345,"second answer");
		Answer a3 = new Answer(246,"third answer");
		java.util.List<Answer> list = new ArrayList<Answer>();
		list.add(a1);;
		list.add(a2);
		list.add(a3);
		q1.setAnswer(list);
		
		Transaction tx = s.beginTransaction();
		s.save(q1);
		tx.commit();
		
	}
}
