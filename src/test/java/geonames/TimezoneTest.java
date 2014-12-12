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
		GeonamesGet gng = new GeonamesGet();

//		test validità url
//		System.out.println(gng.setLat("47.01").setLng("10.2").setUsername());
		
		System.out.println(gng.setLat("47.01").setLng("10.2").setUsername().search());
	}
}
