package DaoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import DAO.ArtistDao;
import DAO.VenueDao;

import util.BandsintownException;
import util.GenericDaoImp;

import entity.Artist;
import entity.Venue;


public class VenueDaoImp extends GenericDaoImp<Venue, String> implements VenueDao {
 
	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#addUser(foo.nerz.bonboard.entity.Users)
	 */
	@Transactional
	public void addVenue(Venue v) throws BandsintownException{
		if(!existVenueId(v.getId())){	
			getSessionFactory().getCurrentSession().save(v);
		}else{
			log.error("Venue ("+v.getId()+") already exists");
			throw new BandsintownException("Venue ("+v.getId()+") already exists");
		}
	}
	
	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#existUsername(java.lang.String)
	 */
	@Transactional
	public boolean existVenueId(int id){
		Query query;
		query=getSessionFactory().getCurrentSession().createQuery("From artists where artist_id=:id");
		query.setParameter("id", id);
		List<Artist> result=query.list();
		if(result.size()>0)return true;
		else return false;
	}
	
	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#deleteUserByUsername(java.lang.String)
	 */
	@Transactional
	public void deleteVenueById(int id) throws BandsintownException{
		if(existVenueId(id)){
			Query query;
			query=getSessionFactory().getCurrentSession().createQuery("From venues where venue_id=:id");
			query.setParameter("id", id);
			List<Venue> result=query.list();
			Venue v=result.get(0);
			getSessionFactory().getCurrentSession().delete(v);
		}else{
			log.error("Venue ("+id+") don't exist and you traying to delete it");
			throw new BandsintownException("Venue ("+id+") don't exist and you traying to delete it");
		}
	}

	public List<Venue> getAllVenues() {
		// TODO Auto-generated method stub
		return null;
	}

//	/* (non-Javadoc)
//	 * @see foo.nerz.bonboard.dao.imp.UserDao#existMail(java.lang.String)
//	 */
//	@Override
//	@Transactional
//	public boolean existMail(String mail) {
//		Query query;
//		query=getSessionFactory().getCurrentSession().createQuery("From Users where Email=:mail");
//		query.setParameter("mail", mail);
//		List<Users> result=query.list();
//		if(result.size()>0)return true;
//		else return false;
//	}
	
	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#getUserByUsername(java.lang.String)
	 */
//	@Override
//	@Transactional
//	public Users getUserByUsername(String username){
//		Users us=(Users) getSessionFactory().getCurrentSession().get(Users.class, username);	
//		return us;
//	}
	
//	/* (non-Javadoc)
//	 * @see foo.nerz.bonboard.dao.imp.UserDao#changePass(java.lang.String, java.lang.String)
//	 */
//	@Override
//	@Transactional
//	public void changePass(String username,String pass){
//		Users u=this.findById(username);
//		u.setPassword(pass);
//		getSessionFactory().getCurrentSession().save(u);
//	}
//
//	@Override
//	@Transactional
//	public boolean checkEnable(String username) {		
//		return findById(username).isEnabled();
//	}
//
//	@Override
//	@Transactional
//	public void deleteLogicaly(String username) {
//		if(existUsername(username)&&checkEnable(username)){
//			Users u=findById(username);
//			u.setEnabled(false);
//			update(u);
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Transactional
//	public List<Users> getUsersEnabled() {
//		
//		return getSessionFactory().getCurrentSession().createQuery("From Users where Enabled= True").list();
//		
//		
//	}
//
//	@Override
//	@Transactional
//	public void enableLogicaly(String username) {
//		if(existUsername(username)&&!checkEnable(username)){
//			Users u=findById(username);
//			u.setEnabled(true);
//			update(u);
//		}
//		
//	}
	
	

}
