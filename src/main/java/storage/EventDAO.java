package storage;

import java.util.List;

import entity.Event;


public interface EventDAO {
	
	public void save(Event p);
    
    public List<Event> list();
}
