package DaoImp;

import java.util.List;

import org.hibernate.Query;

import util.BandsintownException;
import util.GenericDaoImp;
import DAO.ArtistDao;
import DAO.VenueDao;
import entity.Artist;
import entity.Venue;

public class EventDaoImp extends GenericDaoImp<Venue, String> implements VenueDao {

	public void addVenue(Venue v) throws BandsintownException {
		if(!existVenueId(v.getId())){	
			getSessionFactory().getCurrentSession().save(v);
		}else{
			log.error("Venue ("+v.getId()+") already exists");
			throw new BandsintownException("Venue ("+v.getId()+") already exists");
		}
	}

	public boolean existVenueId(int id) {
		Query query;
		query=getSessionFactory().getCurrentSession().createQuery("From venues where venue_id=:id");
		query.setParameter("id", id);
		List<Venue> result=query.list();
		if(result.size()>0)return true;
		else return false;
	}

	public void deleteVenueById(int id) throws BandsintownException {
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

}