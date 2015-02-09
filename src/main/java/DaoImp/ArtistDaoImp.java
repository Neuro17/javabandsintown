package DaoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import DAO.ArtistDao;

import util.BandsintownException;
import util.GenericDaoImp;

import entity.Artist;


public class ArtistDaoImp extends GenericDaoImp<Artist, String> implements ArtistDao {

	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#addUser(foo.nerz.bonboard.entity.Users)
	 */
	@Transactional
	public void addArtist(Artist a) throws BandsintownException{
		if(!existArtistId(a.getId())){	
			getSessionFactory().getCurrentSession().save(a);
		}else{
			log.error("Artist ("+a.getId()+") already exists");
			throw new BandsintownException("Artist ("+a.getId()+") already exists");
		}
	}
	
	/* (non-Javadoc)
	 * @see foo.nerz.bonboard.dao.imp.UserDao#existUsername(java.lang.String)
	 */
	@Transactional
	public boolean existArtistId(String id){
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
	public void deleteArtitById(String id) throws BandsintownException{
		if(existArtistId(id)){
			Query query;
			query=getSessionFactory().getCurrentSession().createQuery("From artists where artist_id=:id");
			query.setParameter("id", id);
			List<Artist> result=query.list();
			Artist a=result.get(0);
			getSessionFactory().getCurrentSession().delete(a);
		}else{
			log.error("Artist ("+id+") don't exist and you traying to delete it");
			throw new BandsintownException("Artist ("+id+") don't exist and you traying to delete it");
		}
	}

	public List<Artist> getAllArtists() {
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
