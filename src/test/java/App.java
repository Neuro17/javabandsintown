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
		
//		artist = ((ArtistGet) bandsintown.getArtist.setArtist("pearl jam").asJson()).search();
//		log.debug(artist);
//		
//		events = ((EventsGet) ((EventsGet) bandsintown.getEvents.setArtist("empire empire").asJson().setApiVersion()).setDate("all")).search();
//		for(Event e : events)
//			log.debug(e);
//		
//		events = ((EventsGet) ((EventsGet) bandsintown.getEvents.setArtist("tale of us")).setDate("2014-11-07,2014-12-12").setApiVersion()).search();
//		for(Event e : events)
//			log.debug(e);
//		
//		artist = ((ArtistGet) bandsintown.getArtist.setArtist("naked famous").setAppId().setApiVersion()).search();
//		System.out.println(artist);
//		
//		events = ((EventsGet) ((EventsGet) bandsintown.getEvents.setArtist("a great big pile of leaves")).setDate("all").setApiVersion()).search();
//		for(Event e : events)
//			log.debug(e);
//		
//		events = ((EventsGet) ((EventsGet) bandsintown.getEvents.setArtist("metallica")).setDate("all").setApiVersion()).search();
//		for(Event e : events)
//			log.debug(e);
	
		artist  = ((ArtistGet) bandsintown.getArtist.setArtist("nobraino").asJson().setApiVersion().setAppId()).search();
		log.debug(artist);
		
		events = ((EventsGet) bandsintown.getEvents.setArtist("nobraino").setApiVersion().setAppId().asJson()).search();
	}

}
