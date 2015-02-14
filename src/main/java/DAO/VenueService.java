package DAO;

import java.util.List;

import entity.Venue;

public class VenueService {

	private static VenueDao venueDao;

	public VenueService() {
		venueDao = new VenueDao();
	}

	public void persist(Venue entity) {
		venueDao.openCurrentSessionwithTransaction();
		venueDao.persist(entity);
		venueDao.closeCurrentSessionwithTransaction();
	}

	public void update(Venue entity) {
		venueDao.openCurrentSessionwithTransaction();
		venueDao.update(entity);
		venueDao.closeCurrentSessionwithTransaction();
	}

	public Venue findById(int id) {
		venueDao.openCurrentSession();
		Venue venue = venueDao.findById(id);
		venueDao.closeCurrentSession();
		return venue;
	}

	public void delete(int id3) {
		venueDao.openCurrentSessionwithTransaction();
		Venue venue = venueDao.findById(id3);
		venueDao.delete(venue);
		venueDao.closeCurrentSessionwithTransaction();
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
