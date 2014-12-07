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
import com.google.gson.JsonPrimitive;

import entity.Artist;
import entity.Event;
import entity.Venue;

public class Extractor {
	
	private static final Logger log = LogManager.getLogger(Extractor.class);
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static ArrayList<Event> extractEvents(JsonElement item){
		ArrayList<Event> events = new ArrayList<Event>();
		JsonObject eventsAsJson = item.getAsJsonObject();
		
		log.debug(item);
		log.debug(eventsAsJson);
		
		for(JsonElement e : eventsAsJson.get("resultsPage").getAsJsonArray()){
			events.add(extractEvent(e));
		}
		return events;
	}
	
	public static Event extractEvent(JsonElement item){
		JsonObject eventsAsJson = item.getAsJsonObject();
		Event event = new Event();
		
		event.setId(eventsAsJson.get("id").getAsInt());
		event.setDatetime(new DateTime(eventsAsJson.get("datetime").getAsString()));
		event.setTitle(eventsAsJson.get("title").getAsString());
		event.setArtist(extractArtists(eventsAsJson.get("artists")));
		event.setVenue(extractVenue(eventsAsJson.get("venue")));
		
		if(!eventsAsJson.get("description").isJsonNull())
			event.setDescription(eventsAsJson.get("description").getAsString());
		
		return event;
	}
	
	private static Venue extractVenue(JsonElement jsonElement) {
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
		
		return venue;
	}

	private static ArrayList<Artist> extractArtists(JsonElement jsonElement) {
		JsonArray artistsAsJson = jsonElement.getAsJsonArray();
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		for(JsonElement a : artistsAsJson)
			artists.add(extractArtist(a));
		
		return artists;
	}

	public static Artist extractArtist(JsonElement item){
		Artist artist;
		JsonObject artistTmp = item.getAsJsonObject();
		
		if(artistTmp.get("mbid").isJsonNull())
			artist = new Artist(artistTmp.get("name").getAsString());
		else
			artist = new Artist(artistTmp.get("name").getAsString(), artistTmp.get("mbid").getAsString());
		
		return artist;
	}
	
}
