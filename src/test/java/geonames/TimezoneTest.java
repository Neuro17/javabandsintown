package geonames;

import java.util.ArrayList;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import search.Bandsintown;

import entity.Event;



public class TimezoneTest {
	
	private final static Logger log = LogManager.getLogger(TimezoneTest.class);

	
	public static void main(String args[]){
//		System.out.println("Siamo nell'" + TimeZone.getDefault().getDisplayName());
//		System.out.println("milli secondi da aggiungere all'orario attuale per raggiungere il GMT: "+TimeZone.getDefault().getDSTSavings());
//		System.out.println("ID della nostra zona: "+TimeZone.getDefault().getID());
//		System.out.println("ore da aggiungere al GMT per avere la nostra ora: " + TimeZone.getDefault().getRawOffset()/3600000);
//		for(String s : TimeZone.getAvailableIDs(3600000))
//		System.out.println(s);
//		System.out.println("Ore da aggiungere a GMT per avere l'ora US/Hawaii: " +TimeZone.getTimeZone("US/Hawaii").getRawOffset()/3600000);
//		System.out.println("La nostra ora rispetta quella legale: " +TimeZone.getDefault().observesDaylightTime());

		GeonamesGet gng = new GeonamesGet();
//		ArrayList<Event> events = new ArrayList<Event>();
		Bandsintown bandsintown = new Bandsintown();
		ArrayList<Event> events = null;
//test validità url
//		System.out.println(gng.setLat("47.01").setLng("10.2").setUsername());

//imposto parametri di ricerca per particolare lat e lng
		/* latitudine distanza dall equatore 
		 * longitudine distanza dal meridiano */
//		System.out.println("Time zone id trovato: " + gng.setLat("51.4791").setLng("0").setUsername().search());
		
//		events = bandsintown.getEvents.setArtist("empire empire").asJson().setDate("all").search();
//		for(Event e : events)
//			log.debug("city: " + e.getVenue().getCity() + "" +
//					" - lat: " + e.getVenue().getLatitude() + "" +
//							" - lng: " + e.getVenue().getLongitude() +"" +
//									" - hour: " + e.getDatetime().getHourOfDay() + "" +
//											" - nimutes: " + e.getDatetime().getMinuteOfHour());

//imposto fuso orario di riferimento quello di londra
		TimeZone.getTimeZone("Europe/London");
//ottengo timezoneId per ogni citta degli eventi
		events = bandsintown.getEvents.setArtist("david guetta").asJson().setDate("upcoming").search();
//		for(Event e : events)
//			log.debug(gng	.setLat(e.getVenue().getLatitude())
//							.setLng(e.getVenue().getLongitude())
//							.setUsername()
//							.search());
//calcolo ore da aggiungere alla TimeZone di default
		for(Event e : events)
			log.trace("Ore da aggiungere alla TimeZone 'Europe/London'" +
					"" +TimeZone.getTimeZone(gng	.setLat(e.getVenue().getLatitude())
													.setLng(e.getVenue().getLongitude())
													.setUsername()
													.search()).getRawOffset()/3600000);
	}
}
