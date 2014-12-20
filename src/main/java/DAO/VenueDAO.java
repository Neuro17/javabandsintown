package DAO;

import java.util.List;

import entity.Venue;

public interface VenueDAO {
	 
    public void save(Venue p);
     
    public List<Venue> list();
     
}
