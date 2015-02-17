package Hibernate;

import java.util.List;

import entity.Artist;

import DAO.ArtistService;

public class HibernateArtistTest {

	public static void main(String[] args) {
		ArtistService artistService = new ArtistService();

//		Create ok
		
//		Artist Artist1 = new Artist("The Brothers Karamazov", "1");
//		Artist Artist2 = new Artist("War and Peace", "2");
//		Artist Artist3 = new Artist("Pride and Prejudice", "3");
//		System.out.println("*** Persist - start ***");
//		artistService.persist(Artist1);
//		artistService.persist(Artist2);
//		artistService.persist(Artist3);
				
//		Read ok
		
//		List<Artist> artists1 = artistService.findAll();
//		System.out.println("Artists Persisted are : " + artists1.size());
//		for (Artist a : artists1) {
//			System.out.println("-" + a.toString());
//		}
//		System.out.println("*** Persist - end ***");

		
//		Update ok		
		
//		System.out.println("*** Update - start ***");
//		Artist Artist1 = new Artist("The Idiot", "1");
//		artistService.update(Artist1);
//		System.out.println("Artist Updated is =>" +artistService.findById(Artist1.getId()));
//		System.out.println("*** Update - end ***");

		
//		Find ok
		
//		System.out.println("*** Find - start ***");
//		Artist Artist1 = new Artist("The Idiot", "3");
//		String id1 = Artist1.getId();
//		Artist another = artistService.findById(id1);
//		System.out.println("Artist found with id " + id1 + " is =>" + another.toString());
//		System.out.println("*** Find - end ***");


//		Delete ok
		
//		System.out.println("*** Delete - start ***");
//		Artist Artist3 = new Artist("Pride and Prejudice", "2");
//		String id3 = Artist3.getId();
//		artistService.delete(id3);
//		System.out.println("Deleted Artist with id " + id3 + ".");
//		System.out.println("Now all Artists are " + artistService.findAll().size() + ".");
//		System.out.println("*** Delete - end ***");
		
//		FindAll no		
		
//		System.out.println("*** FindAll - start ***");
//		List<Artist> Artists2 = artistService.findAll();
//		System.out.println("Artists found are :");
//		for (Artist b : Artists2) {
//			System.out.println("-" + b.toString());
//		}
//		System.out.println("*** FindAll - end ***");

// 		DeleteAll ok
		
//		System.out.println("*** DeleteAll - start ***");
//		artistService.deleteAll();
//		System.out.println("Artists found are now " + artistService.findAll().size());
//		System.out.println("*** DeleteAll - end ***");
		
		System.exit(0);
	}
}
