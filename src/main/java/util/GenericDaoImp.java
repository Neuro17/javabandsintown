package util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Transactional;

/**
 * Generic abstract dao that will be extended from all other dao-s
 * @author Entela Kazazi
 */
public abstract class GenericDaoImp<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> type;
	protected final Log log = LogFactory.getLog(getClass());
	
	
	@Resource(name="sessionFactory")
	 private SessionFactory sessionFactory;
	 
		 public void setSessionFactory(SessionFactory sessionFactory) {
		        this.sessionFactory = sessionFactory;
		    }
	     
		 protected SessionFactory getSessionFactory() {
		        if (sessionFactory == null)
		            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
		        return sessionFactory;
		    }
	
		 public Class<T> getType() {
		        return type;
		    }
		 
	 	@SuppressWarnings("unchecked")
	 	public GenericDaoImp()  {
	        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	    }
	
	 	@SuppressWarnings("unchecked")
		@Transactional(readOnly = true)
	    public T findById(ID id) throws HibernateException {
	        return (T) getSessionFactory().getCurrentSession().get(getType(), id);
	    }
   
	    @Transactional
	    public void delete(T obj) throws HibernateException {
	        getSessionFactory().getCurrentSession().delete(obj);
	    }

	    @Transactional
	    public void update(T obj) throws HibernateException {
	        getSessionFactory().getCurrentSession().update(obj);
	    }
	    
	    @Transactional
	    public void persist(T obj) throws HibernateException {
	        getSessionFactory().getCurrentSession().persist(obj);
	    }
	    
	    @Transactional
	    public long save(T obj) throws HibernateException {
	       Long id = (Long)getSessionFactory().getCurrentSession().save(obj);
	       return id.longValue();
	    }
	    
	    @Transactional
	    public void saveOrUpdate(T obj) throws HibernateException {
	    	getSessionFactory().getCurrentSession().saveOrUpdate(obj);
	      
	    }
	    
	    @Transactional(readOnly = true)
	    public List<T> listAll() throws HibernateException{
	    	String fromClause = "FROM " + getType().getSimpleName();
	    	@SuppressWarnings("unchecked")
			List<T> result =  getSessionFactory().getCurrentSession().createQuery(fromClause).list();
	    	return result;
	    }
	    
	    @Transactional(readOnly = true)
	    public List<T> listAllPage(int page, int recordForPage) throws HibernateException {
			String fromQuery = "from "+ getType().getSimpleName();
			Query query = getSessionFactory().getCurrentSession().createQuery(fromQuery);
			query.setFirstResult((page-1)*recordForPage);
			query.setMaxResults(recordForPage);
			
			@SuppressWarnings("unchecked")
			List<T> result =  (List<T>)query.list();
			return result;
		}
	    
	    @Transactional(readOnly = true)
	    public List<T> listPage(String hqlQueryString, int page, int recordForPage) throws HibernateException {
	    	Query query = getSessionFactory().getCurrentSession().createQuery(hqlQueryString);
			query.setFirstResult((page-1)*recordForPage);
			query.setMaxResults(recordForPage);
			
			@SuppressWarnings("unchecked")
			List<T> result =  (List<T>)query.list();
			return result;
	    }
	    
	    @Transactional(readOnly = true)
	    public long countAll() throws HibernateException {
	    	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(type);
	    	criteria.setProjection(Projections.rowCount());
	    	Long count = (Long) criteria.uniqueResult();
						
			return count.longValue();
	    }
	    
	    @Transactional(readOnly = true)
	    public long countQuery(String sqlQueryString) throws HibernateException{
	    	String queryCount = "Select count(*) FROM (" + sqlQueryString + ")" + "table1"; 
	    	Query query = getSessionFactory().getCurrentSession().createSQLQuery(queryCount);
			BigInteger count = (BigInteger)query.uniqueResult();
			return count.longValue();
	    }
	    
	    @Transactional(readOnly = true)
	    public long getMaxId(String idPropertyName) throws HibernateException{
	    	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(type);
	    	criteria.setProjection(Projections.max(idPropertyName));
	    	Long count = (Long) criteria.uniqueResult();
						
			return count.longValue();
	    }
	    @Transactional
	    public void merge(T entity) throws HibernateException{
	    	getSessionFactory().getCurrentSession().merge(entity);
	    }
	    	    
	}

