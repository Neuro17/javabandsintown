package DAO;

import java.util.List;

import entity.Artist;

public interface ArtistDAO {
	 
    public void save(Artist p);
     
    public List<Artist> list();
     
}
