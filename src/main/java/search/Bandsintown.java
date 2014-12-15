package search;

import requests.ArtistGet;
import requests.EventsGet;
import requests.VenueEventsSearch;

public class Bandsintown {
	
	public ArtistGet getArtist;
	public EventsGet getEvents;
	public VenueEventsSearch getVenues;
	
	public Bandsintown() {
		getArtist = new ArtistGet();
		getEvents = new EventsGet();
		getVenues = new VenueEventsSearch();
	}

}
