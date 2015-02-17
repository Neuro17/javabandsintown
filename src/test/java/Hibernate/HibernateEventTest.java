package Hibernate;

import java.util.List;

import entity.Event;
import entity.Venue;

import DAO.EventService;
import DAO.VenueService;

public class HibernateEventTest {

	public static void main(String[] args) {
		EventService eventService = new EventService();

//		Create ok
		
//		Venue v1 = new Venue();
//		v1.setId(50);		
//		Event e1 = new Event();
//		e1.setId(11); e1.setDescription("firstDescription"); e1.setTitle("firstTitle"); e1.setVenue(v1);
//
//		Venue v2 = new Venue();
//		v2.setId(51);
//		Event e2 = new Event();
//		e2.setId(12);	e2.setDescription("descrizione2"); e2.setTitle("titolo2"); e2.setVenue(v2);
//
//		Venue v3 = new Venue();
//		v3.setId(56);
//		Event e3 = new Event();
//		e3.setId(16); 	e3.setDescription("descrizione3"); e3.setTitle("titolo3"); e3.setVenue(v3);
//
//		System.out.println("*** Persist - start ***");
//		eventService.persist(e1);
//		eventService.persist(e2);
//		eventService.persist(e3);
//		System.out.println("*** Persist - end ***");
//		
//		Update	ok	
//
//		System.out.println("*** Update - start ***");
//		Venue v4 = new Venue();
//		v4.setId(51);		
//		Event e4 = new Event();
//		e4.setId(11); e4.setDescription("kakka"); e4.setTitle("mmerda"); e4.setVenue(v4);
//		eventService.update(e4);
//		System.out.println("*** Update - end ***");
//
//		
//		Find ok
//		
//		System.out.println("*** Find - start ***");
//		Event e5 = new Event();
//		e5.setId(12);
//		Event another = eventService.findById(e5.getId());
//		System.out.println("- Event found [ Id : " + another.getId() + ", Title : "  + another.getTitle() + "]");
//		System.out.println("*** Find - end ***");
//
//
//		Delete ok
//
//		System.out.println("*** Delete - start ***");
//		Event e6 = new Event();
//		e6.setId(12);
//		int id3 = e6.getId();
//		eventService.delete(id3);
//		System.out.println("Deleted Event with id " + id3 + ".");
//		System.out.println("*** Delete - end ***");
//		
//		FindAll ok
//		
//		System.out.println("*** FindAll - start ***");
//		List<Event> Events2 = eventService.findAll();
//		System.out.println("Events found are :");
//		for (Event e : Events2) {
//			System.out.println("- Event found [ Id : " + e.getId() + ", Title : "  + e.getTitle() + "]");
//		}
//		System.out.println("*** FindAll - end ***");
//
// 		DeleteAll ok
//		
//		System.out.println("*** DeleteAll - start ***");
//		eventService.deleteAll();
//		System.out.println("Events found are now " + eventService.findAll().size());
//		System.out.println("*** DeleteAll - end ***");
		
		System.exit(0);
	}
}
