package hibernate;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import storage.ArtistDAO;
import storage.EventDAO;
import storage.VenueDAO;
import entity.Artist;
import entity.Event;
import entity.Venue;
 
public class HibernateMain {
 
    public static void main(String[] args) {
 
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ArtistDAO artistDAO = context.getBean(ArtistDAO.class);
        Artist artist = new Artist("chamber");
        artistDAO.save(artist);
        System.out.println("Sotored: " + artist);

        VenueDAO venueDAO = context.getBean(VenueDAO.class);        
        Venue venue = new Venue();
        venue.setCity("plplpl");
        venue.setCountry("italy");
        venue.setLatitude(45);
        venue.setLongitude(9);
        venue.setRegion("lombardia");
        venueDAO.save(venue);
        System.out.println("Sotored: " + venue);        
        Venue v2 = new Venue();
        v2.setCity("okokokookko");
        v2.setCountry("italy");
        v2.setLatitude(45);
        v2.setLongitude(9);
        v2.setRegion("lombardia");
        venueDAO.save(v2);
        System.out.println("Sotored: " + v2);
//TODO mappare Event adeguatamente        
//        EventDAO eventDAO = context.getBean(EventDAO.class);
//        Event event = new Event();
//        event.setTitle("dietrologia");
//        event.setDescription("porca madompa se funziona");
//        eventDAO.save(event);         
//        System.out.println("Sotored: " + event);
        
//        List<Person> list = personDAO.list();
//         
//        for(Person p : list){
//            System.out.println("Person List::"+p);
//        }
  
        //close resources
        context.close();    		
    }
}