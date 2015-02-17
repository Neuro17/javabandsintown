package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.Event;

public class EventDao implements DaoInterface<Event, Integer> {
	
	private Session currentSession;
	
	private Transaction currentTransaction;

	public EventDao() {
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

	public void persist(Event entity) {
		getCurrentSession().save(entity);
	}

	public void update(Event entity) {
		getCurrentSession().update(entity);
	}

	public Event findById(Integer id) {
		Event entity = (Event) getCurrentSession().get(Event.class, id);
		return entity; 
	}

	public void delete(Event entity) {
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> findAll() {
		List<Event> events = (List<Event>) getCurrentSession().createCriteria(Event.class).list();
		return events;
	}

	public void deleteAll() {
		List<Event> entityList = findAll();
		for (Event entity : entityList) {
			delete(entity);
		}
	}

}
