package com.tut;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println("Project started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        //creating student
        Stuudent st = new Stuudent();
        st.setId(102);
        st.setName("John Abra");
        st.setCity("Delhi");
        System.out.println(st);
        //creating object of address class
        Address ad = new Address();
        ad.setAddressId(101);
        ad.setStreet("street1");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(245.5);
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/wonka.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
                
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
       
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("done");
        
    }
}
