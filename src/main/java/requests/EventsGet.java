package requests;

import http.BandsintownConnector;

import java.util.ArrayList;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import config.BandsintownConfig;
import entity.Event;

public class EventsGet extends BandsintownConnector{
	
	private static final Logger log = LogManager.getLogger(EventsGet.class);

	public EventsGet(){
		uriBld = new URIBuilder();
		buildURI();
		uriBld.setPath(BandsintownConfig.getArtistPath());
	}
	
	public EventsGet setArtist(String name){
		log.trace("Entering setArtist");
		uriBld.setPath(BandsintownConfig.getArtistPath() + "/" + name + "/events");
		log.trace("Exiting setArtist");
		return this;
	}
	
	public EventsGet setDate(String date){
		log.trace("Entering setDate");
		uriBld.setParameter(Paramaters.getDate(), date);
		log.trace("Exiting setDate");
		return this;
	}
	
	public EventsGet asJson(){
		return (EventsGet) super.asJson();
	}
	
	public EventsGet asXML(){
		return (EventsGet) super.asXML();
	}
	
	public EventsGet setArtistID(String id){
		return (EventsGet) super.setArtistID(id);
	}

	public ArrayList<Event> search() {
		log.trace("Entering search");
		JsonObject events;
		
		build();
		events = executeRequest(uri);
		log.debug(events);
//		return null;
		log.trace("Exiting search");
		return Extractor.extractEvents(events);
		
	}

}
