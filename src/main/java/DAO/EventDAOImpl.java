package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Event;


public class EventDAOImpl implements EventDAO {
 
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    public void save(Event p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<Event> list() {
        Session session = this.sessionFactory.openSession();
        List<Event> personList = session.createQuery("from events").list();
        session.close();
        return personList;
    }
 
}

