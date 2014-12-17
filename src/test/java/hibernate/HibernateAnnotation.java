package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import storage.HibernateUtil;

import entity.Artist;
  
public class HibernateAnnotation{
 
    public static void main(String[] args) {
//TODO in hibernate-annotation.cfg.xml c'è da modificare il tag <mapping class= > volta per volta in base 
//alla classe, conviene fare 4 file xml di configurazione per le annotazioni?
    	Artist a = new Artist("fabri fibra", "1");

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(a);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Stored=" + a);
         
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
 
}