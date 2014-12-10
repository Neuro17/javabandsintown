package search;

import requests.ArtistGet;
import requests.EventsGet;

public class Bandsintown {
	
	public ArtistGet getArtist;
	public EventsGet getEvents;
	
	public Bandsintown() {
		getArtist = new ArtistGet();
		getEvents = new EventsGet();
	}

}
