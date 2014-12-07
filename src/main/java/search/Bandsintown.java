package search;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import requests.ArtistGet;
import requests.EventsGet;
import entity.Artist;
import entity.Event;

public class Bandsintown {
	private final static Logger log = LogManager.getLogger(Bandsintown.class);
	private ArtistGet getArtist;
	private EventsGet getEvents;
	
	public Bandsintown() {
		getArtist = new ArtistGet();
		getEvents = new EventsGet();
	}



	public static void main(String[] args) throws IOException {
		Artist artist;
		ArrayList<Event> events = new ArrayList<Event>();
		Bandsintown bandsintown = new Bandsintown();
		
//		bandsintown.getArtist.setArtist("nirvana").asXML().build();
//		
//		String mbid = "9282c8b4-ca0b-4c6b-b7e3-4f7762dfc4d6";
		
		artist = ((ArtistGet) bandsintown.getArtist.setArtist("richie hawtin").asJson()).search();
		log.debug(artist);
		
		events = ((EventsGet) bandsintown.getEvents.setArtist("tale of us").asJson().setApiVersion()).search();
		for(Event e : events)
			log.debug(e);
		
		events = ((EventsGet) ((EventsGet) bandsintown.getEvents.setArtist("tale of us")).setDate("2014-11-07,2014-12-12").setApiVersion()).search();
		for(Event e : events)
			log.debug(e);
	}

}
