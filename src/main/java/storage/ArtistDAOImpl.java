package storage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Artist;

public class ArtistDAOImpl implements ArtistDAO{
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	public void save(Artist p) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
	}

	public List<Artist> list() {
		Session session = this.sessionFactory.openSession();
        List<Artist> artistList = session.createQuery("from Artist").list();
        session.close();
        return artistList;
	}

}
