package util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;



/**
 * GenericDao interface implemented by GenericDaoAbstract
 * @author Entela Kazazi
 */
public interface GenericDao<T, ID extends Serializable> {
	
	
	/**
	 * Retrieve entity by ID 
	 * @param id
	 * @return Entity T
	 * @throws HibernateException
	 */
   public T findById(ID id) throws HibernateException;
   
   /**
    * List all entities
    * @return List<Entity T>
    * @throws HibernateException
    */
 
   public List<T> listAll() throws HibernateException;
   
  /**
   * Persist the entity, makes a transient instance persistent 
   * It will not execute an INSERT statement if it is called 
   * outside of transaction boundaries.
   * @param entity
   * @throws HibernateException
   */
   public void persist(T entity) throws HibernateException;
 
   /**
    * Update the entity
    * @param entity
    * @throws HibernateException
    */
   public void update(T entity) throws HibernateException;
   
   /**
    * Delete the entity
    * @param entity
    * @throws HibernateException
    */
   
   public void delete (T entity) throws HibernateException;
   
   /**
    * Save the entity, returns the identifier 
    * INSERT happens immediately
    * @param entity
    * @return
    * @throws HibernateException
    */
   
   public long save (T entity) throws HibernateException;
   
   /**
    * Save the entity if it has not an id
    * Update the entity if it has an id
    * @param entity
    * @throws HibernateException
    */
   public void saveOrUpdate (T entity) throws HibernateException;
   
   /**
    * Retrieve records to view them in pages
    * @param page: current page
    * @param recordForPage: number of records for each page
    * @return List Entity T
    * @throws HibernateException
    */
   public List<T> listAllPage (int page, int recordForPage) throws HibernateException;
   
   public List<T> listPage(String hqlQueryString, int page, int recordForPage) throws HibernateException;
   
   /**
    * 
    * Returns the total number of records 
    * @return long
    * @throws HibernateException
    */
   public long countAll() throws HibernateException;
   
   
   /**
    * Returns the total number of records returned by a query
    * @param sqlQueryString
    * @return long
    * @throws HibernateException
    */
   public long countQuery(String sqlQueryString) throws HibernateException;
   
   /**
    * Return the max id
    * @param idPropertyName: name of the PK of the Entity
    * @return long
    * @throws HibernateException
    */
   
   public long getMaxId(String idPropertyName) throws HibernateException;
   
   
   public void merge(T entity) throws HibernateException;
   
}
