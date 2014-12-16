package storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EntityStorage {
	private static final Logger log = LogManager.getLogger(EntityStorage.class);

	public void storeEntity(Object entity){
		log.trace("Entering storeEntity");
		
		//Get Session
	    SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	    Session session = sessionFactory.getCurrentSession();
	    //start transaction
	    session.beginTransaction();
	    //Save the Model object
	    session.save(entity);
	    //Commit transaction
	    session.getTransaction().commit();
	    
	    log.trace("Stored: " + entity);
		
	    //terminate session factory, otherwise program won't end
	    sessionFactory.close();
	    
	    log.trace("Exiting storeEntity"); 
		
	}
}
