package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import entity.Venue;

public class VenueDao implements DaoInterface<Venue, Integer> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public VenueDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Venue entity) {
		getCurrentSession().save(entity);
	}

	public void update(Venue entity) {
		getCurrentSession().update(entity);
	}

	public Venue findById(Integer id3) {
		Venue entity = (Venue) getCurrentSession().get(Venue.class, id3);
		return entity; 
	}

	public void delete(Venue entity) {
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Venue> findAll() {
		List<Venue> Venues = (List<Venue>) getCurrentSession().createCriteria(Venue.class).list();
		return Venues;
	}

	public void deleteAll() {
		List<Venue> entityList = findAll();
		for (Venue entity : entityList) {
			delete(entity);
		}
	}

}
