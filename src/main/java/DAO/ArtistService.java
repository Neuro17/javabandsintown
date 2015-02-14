package DAO;

import java.util.List;

import entity.Artist;

public class ArtistService {

	private static ArtistDao artistDao;

	public ArtistService() {
		artistDao = new ArtistDao();
	}

	public void persist(Artist entity) {
		artistDao.openCurrentSessionwithTransaction();
		artistDao.persist(entity);
		artistDao.closeCurrentSessionwithTransaction();
	}

	public void update(Artist entity) {
		artistDao.openCurrentSessionwithTransaction();
		artistDao.update(entity);
		artistDao.closeCurrentSessionwithTransaction();
	}

	public Artist findById(String id) {
		artistDao.openCurrentSession();
		Artist artist = artistDao.findById(id);
		artistDao.closeCurrentSession();
		return artist;
	}

	public void delete(String id) {
		artistDao.openCurrentSessionwithTransaction();
		Artist artist = artistDao.findById(id);
		artistDao.delete(artist);
		artistDao.closeCurrentSessionwithTransaction();
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
