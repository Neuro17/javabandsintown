package DAO;

import java.util.List;

import entity.Event;
import entity.Venue;

public class EventService {

	private static EventDao eventDao;

	public EventService() {
		eventDao = new EventDao();
	}

	public void persist(Event entity) {
		VenueService venueServiceTmp = new  VenueService();
		Venue venue = venueServiceTmp.findById(entity.getVenue().getId());

		EventService eventServiceTmp = new EventService();
		Event event = eventServiceTmp.findById(entity.getId());
		
		if(venue != null)
		{	
			if(event == null){
				eventDao.openCurrentSessionwithTransaction();
				eventDao.persist(entity);
				eventDao.closeCurrentSessionwithTransaction();
			}
			else{
				System.out.println("Event with Id: " + entity.getId() + " already exists in the DataBase");
			}
		}
		else{
			System.out.println("Venue with Id: " + entity.getVenue().getId() + " doesn't exist in the DataBase");
		}
	}

	public void update(Event entity) {
		EventService eventServiceTmp = new EventService();
		Event event = eventServiceTmp.findById(entity.getId());
		
		if(event != null){
			eventDao.openCurrentSessionwithTransaction();
			eventDao.update(entity);
			eventDao.closeCurrentSessionwithTransaction();
		}
		else{
			System.out.println("Event with Id: " + entity.getId() + " doesn't exist in the DataBase");
		}
	}

	public Event findById(Integer id) {
		eventDao.openCurrentSession();
		Event event = eventDao.findById(id);
		eventDao.closeCurrentSession();
		return event;
	}

	public void delete(Integer id) {
		EventService eventServiceTmp = new EventService();
		Event event = eventServiceTmp.findById(id);
		
		if(event != null){
			eventDao.openCurrentSessionwithTransaction();
			eventDao.delete(event);
			eventDao.closeCurrentSessionwithTransaction();
		}
		else{
			System.out.println("Event with Id: " + id + " doesn't exists in the Database");
		}
	}

	public List<Event> findAll() {
		eventDao.openCurrentSession();
		List<Event> events = eventDao.findAll();
		eventDao.closeCurrentSession();
		return events;
	}

	public void deleteAll() {
		eventDao.openCurrentSessionwithTransaction();
		eventDao.deleteAll();
		eventDao.closeCurrentSessionwithTransaction();
	}

	public EventDao eventDao() {
		return eventDao();
	}
}
