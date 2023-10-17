package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapdemo {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 //creating question
		 Question q1 = new Question();
		 q1.setQuestionId(101);
		 q1.setQuestion("What is Java");//2104190109001
		 
		 //creating answer object
		 Answer answer = new Answer();
		 answer.setAnswerId(201);
		 answer.setAnswer("java is programming language");
		 answer.setQ(q1);
		 q1.setAnswer(answer);
		 
		 //session
		 Session s = factory.openSession();
		 Transaction tx = s.beginTransaction();
		 //save
		 s.save(answer);
		 s.save(q1);
		 
		 
		 tx.commit();
		 s.close();
		 
		 
		 factory.close();
	}
}
