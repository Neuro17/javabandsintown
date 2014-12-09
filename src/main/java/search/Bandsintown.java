package search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import requests.ArtistGet;
import requests.EventsGet;

public class Bandsintown {
	
	@SuppressWarnings("unused")
	private final static Logger log = LogManager.getLogger(Bandsintown.class);
	public ArtistGet getArtist;
	public EventsGet getEvents;
	
	public Bandsintown() {
		getArtist = new ArtistGet();
		getEvents = new EventsGet();
	}

}
