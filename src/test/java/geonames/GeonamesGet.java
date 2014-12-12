package geonames;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

public class GeonamesGet extends GeonamesConnector{
	private static final Logger log = LogManager.getLogger(GeonamesGet.class);
	
	public GeonamesGet(){
		uriBld = new URIBuilder();
		buildURI();
//		log.trace(uriBld);
	}
	
	public GeonamesGet setLat(double lat) {
//		log.trace("Entering setLat");
		uriBld.setParameter("lat", Double.toString(lat));
//		log.trace(super.uriBld);
//		log.trace("Exiting setLat");
		return this;
	}
	
	public GeonamesGet setLng(double lng) {
//		log.trace("Entering setLng");
		uriBld.setParameter("lng", Double.toString(lng));
//		log.trace(super.uriBld);
//		log.trace("Exiting setLng");
		return this;
	}
	

	public GeonamesGet setUsername() {
//		log.trace("Entering setUsername");
		uriBld.setParameter("username",GeonamesConfig.getUsername());
//		log.trace(super.uriBld);
//		log.trace("Exiting setUsername");
		return this;
	}
	
	public GeonamesGet setJson(){
//		log.trace("Entering setJson");
		uriBld.setPath(GeonamesConfig.getTimeZoneJson() + "?");
//		log.trace("Exiting setJson");
		return this;
	}
	/*
	 * restituisce il timezoneId della lat e lng specificate
	 */
	public String search(){
//		log.trace("Entering search on geonames.org");
		JsonObject geoNamesAsJson;
		String s;
		
		build();
//		log.debug(uri);
		geoNamesAsJson = executeRequest(uri);
//		log.debug(geoNamesAsJson);
		
		s = geoNamesAsJson.getAsJsonObject().get("timezoneId").getAsString();
		
//		log.trace("Exiting search from geonames.org");
		
		return s;
	}
}