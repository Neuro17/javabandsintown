package requests;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import search.Get;

import com.google.gson.JsonObject;

import http.BandsintownConnector;
import config.BandsintownConfig;
import entity.Artist;

public class ArtistGet extends BandsintownConnector implements Get{
	private static final Logger log = LogManager.getLogger(ArtistGet.class);

	private URI uri;
	
	public ArtistGet(){
		uriBld = new URIBuilder();
		buildURI();
		uriBld.setPath(BandsintownConfig.getArtistPath());
	}
	

	public BandsintownConnector setArtist(String name){
		uriBld.setPath(BandsintownConfig.getArtistPath() + "/" + name);
		return this;
	}
	
	public Artist search(){
		Artist artist;
		JsonObject artistAsJson;
		
		build();
		artistAsJson = executeRequest(uri);
		log.debug(artistAsJson);
		return Extractor.extractArtist(artistAsJson);
	}
	
	public void build(){
		setAppId();
		try {
			uri = uriBld.build();
			log.debug(uri);
		} catch (URISyntaxException e) {
			log.error(e.getMessage());
		}
	}

}
