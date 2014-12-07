package search;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.Artist;
import requests.ArtistGet;
import requests.EventsGet;

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
		Bandsintown bandsintown = new Bandsintown();
		
//		bandsintown.getArtist.setArtist("nirvana").asXML().build();
//		
//		String mbid = "9282c8b4-ca0b-4c6b-b7e3-4f7762dfc4d6";
		
		artist = ((ArtistGet) bandsintown.getArtist.setArtist("casfhiuasfhaiu").asJson()).search();
		log.debug(artist);
		
		bandsintown.getEvents.setArtist("tale of us").asXML().build();

	}

}
