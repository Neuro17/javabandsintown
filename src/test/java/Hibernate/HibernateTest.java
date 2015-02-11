package Hibernate;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.HibernateUtil;

import entity.Artist;

public class HibernateTest {

	public static void main( String[] args )
    {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
        session.beginTransaction();
        Artist a = new Artist("ultimo","72"); 
        session.save(a);
        session.getTransaction().commit();
	        
        System.out.println("Artist saved!");
    }
	
}
