package DAO;

import java.util.List;

import util.BandsintownException;
import util.GenericDao;

import entity.Venue;

public interface VenueDao extends GenericDao<Venue,String>  {

	public void addVenue(Venue v) throws BandsintownException;

	public boolean existVenueId(int id);

	public void deleteVenueById(int id)	throws BandsintownException;

//	public boolean existMail(String mail);

//	public abstract Users getUserByUsername(String username);
	
//	public boolean checkEnable(String username);
	
//	public void deleteLogicaly(String username);
	
//	public void enableLogicaly(String username);

//	public void changePass(String username, String pass);
	
	public List<Venue> getAllVenues();
	
}
