package storage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Venue;

public class VenueDAOImpl implements VenueDAO{
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	public void save(Venue p) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
	}

	public List<Venue> list() {
		Session session = this.sessionFactory.openSession();
        List<Venue> venueList = session.createQuery("from Venue").list();
        session.close();
        return venueList;
	}

}