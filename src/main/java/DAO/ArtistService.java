package DAO;

import java.util.List;

import entity.Artist;

public class ArtistService {

	private static ArtistDao artistDao;

	public ArtistService() {
		artistDao = new ArtistDao();
	}

	public void persist(Artist entity) {
		ArtistService artistServiceTmp = new ArtistService();
		Artist artist = artistServiceTmp.findById(entity.getName());
		
		if(artist == null){
			artistDao.openCurrentSessionwithTransaction();
			artistDao.persist(entity);
			artistDao.closeCurrentSessionwithTransaction();
		}
		else{
			System.out.println("Artist with Name: " + entity.getName() + " already exists in the DataBase");
		}
	}

	public void update(Artist entity) {
		ArtistService artistServiceTmp = new ArtistService();
		Artist artist = artistServiceTmp.findById(entity.getName());
		
		if(artist != null){
			artistDao.openCurrentSessionwithTransaction();
			artistDao.update(entity);
			artistDao.closeCurrentSessionwithTransaction();
		}
		else{
			System.out.println("Artist with Name: " + entity.getName() + " doesn't exist in the DataBase");
		}
	}

	public Artist findById(String id) {
		artistDao.openCurrentSession();
		Artist artist = artistDao.findById(id);
		artistDao.closeCurrentSession();
		return artist;
	}

	public void delete(String id) {
		ArtistService artistServiceTmp = new ArtistService();
		Artist artist = artistServiceTmp.findById(id);
		
		if(artist != null){
			artistDao.openCurrentSessionwithTransaction();
			artistDao.delete(artist);
			artistDao.closeCurrentSessionwithTransaction();
		}
		else{
			System.out.println("Artist with Name: " + id + " doesn't exist in the DataBase");
		}
	}

	public List<Artist> findAll() {
		artistDao.openCurrentSession();
		List<Artist> artists = artistDao.findAll();
		artistDao.closeCurrentSession();
		return artists;
	}

	public void deleteAll() {
		artistDao.openCurrentSessionwithTransaction();
		artistDao.deleteAll();
		artistDao.closeCurrentSessionwithTransaction();
	}

	public ArtistDao artistDao() {
		return artistDao();
	}
}
