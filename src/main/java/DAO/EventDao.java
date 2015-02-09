package DAO;

import java.util.List;

import util.GenericDao;

import entity.Event;

public interface EventDao extends GenericDao<Event,Long> {

//	public int getCountByType(int tipo);

	public List<Event> getAllEvents();
	
}