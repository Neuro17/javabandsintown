package requests;

import http.BandsintownConnector;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import config.BandsintownConfig;
import entity.Artist;

public class ArtistGet extends BandsintownConnector{
	private static final Logger log = LogManager.getLogger(ArtistGet.class);
	
	public ArtistGet(){
		uriBld = new URIBuilder();
		buildURI();
		uriBld.setPath(BandsintownConfig.getArtistPath());
	}
	

	public ArtistGet setArtist(String name){
		log.trace("Entering setArtist");
		uriBld.setPath(BandsintownConfig.getArtistPath() + "/" + name);
		log.trace("Exiting setArtist");
		return this;
	}
	
	public Artist search(){
		log.trace("Entering search");
		JsonObject artistAsJson;
		
		build();
		log.debug(uri);
		artistAsJson = executeRequest(uri);
		log.debug(artistAsJson);
		log.trace("Exiting search");
		return Extractor.extractArtist(artistAsJson);
	}
}
