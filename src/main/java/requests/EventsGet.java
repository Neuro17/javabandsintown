package requests;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import search.Get;
import config.BandsintownConfig;
import entity.Event;
import entity.entity;
import http.BandsintownConnector;

public class EventsGet extends BandsintownConnector implements Get{
	
	private static final Logger log = LogManager.getLogger(EventsGet.class);

	private URI uri;
	
	public EventsGet(){
		uriBld = new URIBuilder();
		buildURI();
		uriBld.setPath(BandsintownConfig.getArtistPath());
	}
	
	public BandsintownConnector setArtist(String name){
		uriBld.setPath(BandsintownConfig.getArtistPath() + "/" + name + "/events");
		return this;
	}
	
	public BandsintownConnector setDate(String date){
		uriBld.setParameter(Paramaters.getDate(), date);
		return this;
	}

	@Override
	public void build() {
		setAppId();
		try {
			uri = uriBld.build();
			log.debug(uri);
		} catch (URISyntaxException e){
			log.error(e.getMessage());
		}

	}

	public ArrayList<Event> search() {
		JsonObject events;
		
		build();
		events = executeRequest(uri);
		log.debug(events);
//		return null;
		return Extractor.extractEvents(events);
		
	}

}
