import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import search.Bandsintown;
import entity.Artist;
import entity.Event;
import entity.Venue;


public class App {
	
	private final static Logger log = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		Artist artist;
		ArrayList<Event> events = new ArrayList<Event>();
		ArrayList<Venue> venues = new ArrayList<Venue>();
		Bandsintown bandsintown = new Bandsintown();
		
//		
//		String mbid = "9282c8b4-ca0b-4c6b-b7e3-4f7762dfc4d6";
//		

//non trovando l artista ritorna un puntatore a null
		artist = bandsintown.getArtist.setArtist("Shakira").asJson().search();
		log.debug(artist);
		
//		artist = bandsintown.getArtist.setArtist("paul kalkbrenner").asJson().search();
//		log.debug(artist);
/*		
		events = bandsintown.getEvents.setArtist("paul kalkbrenner").asJson().setDate("all").search();
		for(Event e : events)
			log.debug(e);
		
		events = bandsintown.getEvents.setArtist("tale of us").setDate("2014-11-07,2014-12-12").search();
		for(Event e : events)
			log.debug(e);
		
		artist = bandsintown.getArtist.setArtist("beyoncè").search();
		System.out.println(artist);

		events = bandsintown.getEvents.setArtist("a great big pile of leaves").setDate("all").search();
		for(Event e : events)
			log.debug(e);

//non trovando eventi ritorna un puntatore a null
		events = bandsintown.getEvents.setArtist("jhafdabfhjakdfuy").setDate("all").search();
		if(events != null)
			for(Event e : events)
				log.debug(e);	
		else
			log.debug("no events found");
		
		events = bandsintown.getEvents.setArtist("david bowie").setDate("upcoming").search();
		for(Event e : events)
			log.debug(e);
	
		artist  = bandsintown.getArtist.setArtist("nobraino").asJson().search();
		log.debug(artist);
		
		events = bandsintown.getEvents.setArtist("marta sui tubi").setDate("all").asJson().search();
		for(Event e : events)
			log.debug(e.getDatetime() +" " + e.getVenue().getCity() + " " + e.getVenue().getCountry());

		venues = bandsintown.getVenues.query("london").asJson().setPerPage(100).search();
		for (Venue v : venues) {
			log.debug(v);
		}
		log.debug(venues.size());
		
		venues = bandsintown.getVenues.query("rome").setPerPage(100).setPage(1).asJson().search();
		for (Venue v : venues) {
			log.debug(v);
		}
		log.debug(venues.size());

		venues.addAll(bandsintown.getVenues.nextPage());
		for (Venue v : venues) {
			log.debug(v);
		}
		log.debug(venues.size());
*/
	}

}
