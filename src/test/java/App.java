import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import requests.ArtistGet;
import requests.EventsGet;
import search.Bandsintown;
import entity.Artist;
import entity.Event;


public class App {
	
	private final static Logger log = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		Artist artist;
		ArrayList<Event> events = new ArrayList<Event>();
		Bandsintown bandsintown = new Bandsintown();
		
//		bandsintown.getArtist.setArtist("nirvana").asXML().build();
//		
//		String mbid = "9282c8b4-ca0b-4c6b-b7e3-4f7762dfc4d6";
		
		artist = bandsintown.getArtist.setArtist("pearl jam").asJson().search();
		log.debug(artist);
		
		events = bandsintown.getEvents.setArtist("empire empire").asJson().setDate("all").search();
		for(Event e : events)
			log.debug(e);
		
		events = bandsintown.getEvents.setArtist("tale of us").setDate("2014-11-07,2014-12-12").search();
		for(Event e : events)
			log.debug(e);
		
		artist = bandsintown.getArtist.setArtist("naked famous").search();
		System.out.println(artist);
		
		events = bandsintown.getEvents.setArtist("a great big pile of leaves").setDate("all").search();
		for(Event e : events)
			log.debug(e);
		
		events = bandsintown.getEvents.setArtist("metallica").setDate("all").search();
		for(Event e : events)
			log.debug(e);
	
		artist  = bandsintown.getArtist.setArtist("nobraino").asJson().search();
		log.debug(artist);
		
		events = bandsintown.getEvents.setArtist("nobraino").setDate("all").asJson().search();
		for(Event e : events)
			log.debug(e);

	}

}
