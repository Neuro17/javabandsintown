package Hibernate;

import java.util.List;

import entity.Artist;

import DAO.ArtistService;

public class HibernateArtistTest {

	public static void main(String[] args) {
		ArtistService artistService = new ArtistService();

//		Create ok
//		
//		System.out.println("*** Persist - start ***");
//		Artist Artist1 = new Artist("The Brothers Karamazov", "1");
//		Artist Artist2 = new Artist("War and Peace", "2");
//		Artist Artist3 = new Artist("Pride and Prejudice", "3");
//		System.out.println("*** Persist - start ***");
//		artistService.persist(Artist1);
//		artistService.persist(Artist2);
//		artistService.persist(Artist3);
//		System.out.println("*** Persist - end ***");
		
//		Update ok		
//		
//		System.out.println("*** Update - start ***");
//		Artist Artist1 = new Artist("War and Peace", "99");
//		artistService.update(Artist1);
//		System.out.println("Artist Updated is =>" +artistService.findById(Artist1.getName()));
//		Artist Artist2 = new Artist("Inaggiornabile", "0");
//		artistService.update(Artist2);
//		System.out.println("*** Update - end ***");
		
//		Find ok
//		
//		System.out.println("*** Find - start ***");
//		Artist Artist1 = new Artist("Pride and Prejudice", null);
//		String id1 = Artist1.getName();
//		Artist another = artistService.findById(id1);
//		System.out.println("Artist found with Name: " + id1 + " is =>" + another.toString());
//		System.out.println("*** Find - end ***");


//		Delete ok
//		
//		System.out.println("*** Delete - start ***");
//		Artist Artist3 = new Artist("The Brothers Karamazov", null);
//		String id3 = Artist3.getName();
//		artistService.delete(id3);
//		System.out.println("Deleted Artist with id " + id3 + ".");
//		Artist Artist31 = new Artist("Inesistente", "0");
//		String id31 = Artist31.getName();
//		artistService.delete(id31);
//		System.out.println("*** Delete - end ***");
		
//		FindAll ok		
//		
//		System.out.println("*** FindAll - start ***");
//		List<Artist> Artists2 = artistService.findAll();
//		System.out.println("Artists found are :");
//		for (Artist a : Artists2) {
//			System.out.println("-" + a.toString());
//		}
//		System.out.println("*** FindAll - end ***");

// 		DeleteAll ok
//		
//		System.out.println("*** DeleteAll - start ***");
//		artistService.deleteAll();
//		System.out.println("Artists found are now " + artistService.findAll().size());
//		System.out.println("*** DeleteAll - end ***");
		
		System.exit(0);
	}
}
