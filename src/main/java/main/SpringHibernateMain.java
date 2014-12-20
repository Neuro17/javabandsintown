package main;

import java.util.List;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Artist;
import entity.Event;
import entity.Venue;

import DAO.ArtistDAO;
import DAO.EventDAO;
import DAO.VenueDAO;
  
public class SpringHibernateMain {
 
    public static void main(String[] args) {
 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//   ARTIST OK      
//        ArtistDAO artistDAO = context.getBean(ArtistDAO.class);
//        Artist artist = new Artist("pappa","548");
//        artistDAO.save(artist);
//        System.out.println("Stored: " + artist);
        
//TODO 
        VenueDAO venueDAO = context.getBean(VenueDAO.class);
        Venue v = new Venue();
        v.setId(2654);
        v.setLatitude(-26.55);
        v.setLongitude(18.63);
        v.setName("locanda dei porci");
        v.setCountry("culonia");
        v.setCity("timbuctu");
        venueDAO.save(v);
        System.out.println("Stored: " + v);

//        EventDAO eventDAO = context.getBean(EventDAO.class);
//        Event e = new Event();
//        e.setId(12);
//        e.setTitle("cazzi e mazzi");
//        eventDAO.save(e);
//        System.out.println("Stored: " + e);
        
//        List<Artist> list = personDAO.list();
//         
//        for(Artist p : list){
//            System.out.println("Person List::"+p);
//        }
        //close resources
        context.close();    
    }
}