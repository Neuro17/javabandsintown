package requests;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.BandsintownConfig;
import http.BandsintownConnector;

public class EventsGet extends BandsintownConnector {
	
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

}
