package requests;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import entity.Artist;
import entity.Event;
import entity.Venue;

public class Extractor {
	
	private static final Logger log = LogManager.getLogger(Extractor.class);
	
	@SuppressWarnings("unused")
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static ArrayList<Event> extractEvents(JsonElement item){
		log.trace("Entering extractEvents");
		ArrayList<Event> events = new ArrayList<Event>();
		JsonObject eventsAsJson = item.getAsJsonObject();
		
		log.debug(item);
		log.debug(eventsAsJson);
		
		for(JsonElement e : eventsAsJson.get("resultsPage").getAsJsonArray()){
			events.add(extractEvent(e));
		}
		log.trace("Exiting extractEvents");
		return events;
	}
	
	public static Event extractEvent(JsonElement item){
		log.trace("Entering extractEvent");
		JsonObject eventsAsJson = item.getAsJsonObject();
		Event event = new Event();
		
		event.setId(eventsAsJson.get("id").getAsInt());
		event.setDatetime(new DateTime(eventsAsJson.get("datetime").getAsString()));
		event.setTitle(eventsAsJson.get("title").getAsString());
		event.setArtist(extractArtists(eventsAsJson.get("artists")));
		event.setVenue(extractVenue(eventsAsJson.get("venue")));
		
		if(!eventsAsJson.get("description").isJsonNull())
			event.setDescription(eventsAsJson.get("description").getAsString());
		
		log.trace("Exiting extractEvent");
		return event;
	}
	
	public static Venue extractVenue(JsonElement jsonElement) {
		log.trace("Entering extractVenue");
		JsonObject venueAsJson = jsonElement.getAsJsonObject();
		Venue venue = new Venue();
		
//		log.debug(gson.toJson(venueAsJson));
		
		venue.setCity(venueAsJson.get("city").getAsString());
		venue.setCountry(venueAsJson.get("country").getAsString());
		venue.setName(venueAsJson.get("name").getAsString());
		venue.setLatitude(venueAsJson.get("latitude").getAsDouble());
		venue.setLongitude(venueAsJson.get("longitude").getAsDouble());
		
		if(!venueAsJson.get("region").isJsonNull())
			venue.setRegion(venueAsJson.get("region").getAsString());
		
		log.trace("Exiting extractVenue");
		return venue;
	}

	public static ArrayList<Artist> extractArtists(JsonElement jsonElement) {
		log.trace("Entering extractArtists");
		JsonArray artistsAsJson = jsonElement.getAsJsonArray();
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		for(JsonElement a : artistsAsJson)
			artists.add(extractArtist(a));
		
		log.trace("Exiting extractArtists");
		return artists;
	}

	public static Artist extractArtist(JsonElement item){
		log.trace("Entering extractArtist");
		Artist artist;
		JsonObject artistTmp = item.getAsJsonObject();
		log.debug(artistTmp);
		if(artistTmp.get("mbid").isJsonNull())
			artist = new Artist(artistTmp.get("name").getAsString());
		else
			artist = new Artist(artistTmp.get("name").getAsString(), artistTmp.get("mbid").getAsString());
		
		log.trace("Exiting extractArtist");
		return artist;
	}
	
}
