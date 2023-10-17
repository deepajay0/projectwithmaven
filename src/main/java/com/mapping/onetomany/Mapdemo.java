package com.mapping.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapdemo {
	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 //creating question
//		 Question q1 = new Question();
//		 q1.setQuestionId(101);
//		 q1.setQuestion("What is Java");
//		 
//		 //creating answer object
//		 Answer answer = new Answer();
//		 answer.setAnswerId(201);
//		 answer.setAnswer("java is programming language");
//		 answer.setQ(q1);
//		 
//		 Answer answer1 = new Answer();
//		 answer1.setAnswerId(202);
//		 answer1.setAnswer("java is programming language and it is used to build web and standalone application");
//		 answer1.setQ(q1);
//		 
//		 List<Answer> list = new ArrayList<Answer>();
//		 list.add(answer1);
//		 list.add(answer);
//		 q1.setAnswer(list);
		 
		 
		 //session
		 Session s = factory.openSession();
//		 Transaction tx = s.beginTransaction();
//		 save
//		 s.save(q1);
//		 s.save(answer);
//		 s.save(answer1);
//		 
//		 
//		 
//		 tx.commit();
		 
		 Question q = (Question)s.get(Question.class, 101);
		 System.out.println(q.getQuestionId());
		 System.out.println(q.getQuestion());
		 System.out.println(q.getAnswer().size());
		 
		 s.close();
		 
		 
		 factory.close();
	}
}
