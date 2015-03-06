package geonames;

public class TimezoneTest {
		
	public static void main(String args[]){
//		System.out.println("Siamo nell'" + TimeZone.getDefault().getDisplayName());
//		System.out.println("milli secondi da aggiungere all'orario attuale per raggiungere il GMT: "+TimeZone.getDefault().getDSTSavings());
//		System.out.println("ID della nostra zona: "+TimeZone.getDefault().getID());
//		System.out.println("ore da aggiungere al GMT per avere la nostra ora: " + TimeZone.getDefault().getRawOffset()/3600000);
//		for(String s : TimeZone.getAvailableIDs(3600000))
//		System.out.println(s);
//		System.out.println("Ore da aggiungere a GMT per avere l'ora US/Hawaii: " +TimeZone.getTimeZone("US/Hawaii").getRawOffset()/3600000);
//		System.out.println("La nostra ora rispetta quella legale: " +TimeZone.getDefault().observesDaylightTime());

//		GeonamesGet gng = new GeonamesGet();
//		Bandsintown bandsintown = new Bandsintown();
//		ArrayList<Event> events = null;
//		ArrayList<Event> eventsGMT = null;
		
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
//		TimeZone.getTimeZone("Europe/London");
//ottengo timezoneId per ogni citta degli eventi
//		events = bandsintown.getEvents.setArtist("steve aoki").asJson().setDate("upcoming").searchGMTReferences();
//		for(Event e : events)
//			log.debug(gng	.setLat(e.getVenue().getLatitude())
//							.setLng(e.getVenue().getLongitude())
//							.setUsername()
//							.search());
//calcolo ore da aggiungere alla TimeZone di default
//		for(Event e : events)
//			log.trace("Ore da aggiungere alla TimeZone 'Europe/London'" +TimeZone.getTimeZone
//					(gng	.setLat(e.getVenue().getLatitude())
//							.setLng(e.getVenue().getLongitude())
//							.setUsername()
//							.search())
//					.getRawOffset()/3600000);

//stampo città data orario e relativo MGT+/-Hours		
//		for(Event e : events){
//			int timeToAdd = gng.getHoursToAddToGMT(e.getVenue().getLatitude(), e.getVenue().getLongitude()); 
//			log.trace(	"City:" + e.getVenue().getCity() +
//						" Date: " + e.getDatetime().getDayOfMonth() + "-" + e.getDatetime().getMonthOfYear() + "-" + e.getDatetime().getYear() +
//							" Hour: " + e.getDatetime().getHourOfDay() + ":" + e.getDatetime().getMinuteOfHour() + " (GMT" +  
//						 ((timeToAdd>0)? "+" + timeToAdd :timeToAdd )+ ")");
//			}

//test aggiunta 12 ore a tutti i risultati
//		for(Event e : events){
//		int timeToAdd = gng.getHoursToAddToGMT(e.getVenue().getLatitude(), e.getVenue().getLongitude()); 
//		log.trace(	" \nDate: " + e.getDatetime().getDayOfMonth() + "-" + e.getDatetime().getMonthOfYear() + "-" + e.getDatetime().getYear() +
//					" Hour: " + e.getDatetime().getHourOfDay() + ":" + e.getDatetime().getMinuteOfHour() + " (GMT" +  
//					((timeToAdd>0)? "+" + timeToAdd :timeToAdd )+ ")" +
//					" \nDate: " + e.getDatetime().plusHours(12).getDayOfMonth() + "-" + e.getDatetime().plusHours(12).getMonthOfYear() + "-" + e.getDatetime().plusHours(12).getYear() +
//					" Hour(+6): " + e.getDatetime().plusHours(12).getHourOfDay() + ":" + e.getDatetime().plusHours(12).getMinuteOfHour() + " (GMT" +  
//					((timeToAdd>0)? "+" + timeToAdd :timeToAdd )+ ")" );
//		}
//		events = bandsintown.getEvents.setArtist("steve aoki").asJson().setDate("upcoming").search();	
//		events = bandsintown.getEvents.setArtist("steve aoki").asJson().setDate("upcoming").search();	
//		eventsGMT = bandsintown.getEvents.setArtist("steve aoki").asJson().setDate("upcoming").searchGMTReferences();	
//		for(int i=0;i<events.size();i++){
//			log.trace("\n" + events.get(i).getDatetime() + "\n" + eventsGMT.get(i).getDatetime() );
//		}
	}
}
