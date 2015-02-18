package DAO;

import java.util.List;

import entity.Venue;

public class VenueService {

	private static VenueDao venueDao;

	public VenueService() {
		venueDao = new VenueDao();
	}

	public void persist(Venue entity) {
		VenueService venueServiceTmp = new VenueService();
		Venue venue = venueServiceTmp.findById(entity.getId());
		if(venue == null){
			venueDao.openCurrentSessionwithTransaction();
			venueDao.persist(entity);
			venueDao.closeCurrentSessionwithTransaction();
		}
		else {
			System.out.println("Venue with Id: " + entity.getId() + " already exists in DataBase");
		}
	}

	public void update(Venue entity) {
		VenueService venueServiceTmp = new VenueService();
		Venue venue = venueServiceTmp.findById(entity.getId());
		if(venue != null){		
			venueDao.openCurrentSessionwithTransaction();
			venueDao.update(entity);
			venueDao.closeCurrentSessionwithTransaction();
		}
		else {
			System.out.println("Venue with Id: " + entity.getId() + " doesn't exist in DataBase");
		}
	}

	public Venue findById(int id) {
		venueDao.openCurrentSession();
		Venue venue = venueDao.findById(id);
		venueDao.closeCurrentSession();
		return venue;
	}

	public void delete(int id) {
		VenueService venueServiceTmp = new VenueService();
		Venue venue = venueServiceTmp.findById(id);
		if(venue != null){
			venueDao.openCurrentSessionwithTransaction();
			venueDao.delete(venue);
			venueDao.closeCurrentSessionwithTransaction();
		}
		else {
			System.out.println("Venue with Id: " + id + " doesn't exist in DataBase");
		}
	}

	public List<Venue> findAll() {
		venueDao.openCurrentSession();
		List<Venue> venues = venueDao.findAll();
		venueDao.closeCurrentSession();
		return venues;
	}

	public void deleteAll() {
		venueDao.openCurrentSessionwithTransaction();
		venueDao.deleteAll();
		venueDao.closeCurrentSessionwithTransaction();
	}

	public VenueDao venueDao() {
		return venueDao();
	}
}
