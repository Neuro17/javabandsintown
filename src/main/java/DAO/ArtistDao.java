package DAO;

import java.util.List;

import util.BandsintownException;
import util.GenericDao;

import entity.Artist;

public interface ArtistDao extends GenericDao<Artist,String>  {

	public void addArtist(Artist a) throws BandsintownException;

	public boolean existArtistId(String id);

	public void deleteArtitById(String id) throws BandsintownException;

//	public boolean existMail(String mail);

//	public abstract Users getUserByUsername(String username);
	
//	public boolean checkEnable(String username);
	
//	public void deleteLogicaly(String username);
	
//	public void enableLogicaly(String username);

//	public void changePass(String username, String pass);
	
	public List<Artist> getAllArtists();

}
