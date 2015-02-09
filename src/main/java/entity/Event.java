package entity;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="events")

public class Event {
	@Id
    @Column(name="event_id")
	private int id;
	
	@Column(name="event_title")
	private String title;
	
//	@Column(name="event_date")
	private DateTime datetime;
	
	@Column(name="event_description")
	private String description;

//	@ManyToOne(orphanRemoval=true,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="artist_id")
	private ArrayList<Artist> artist;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="venue_id",referencedColumnName="venue_id")
	private Venue venue;
	
	public Event(Integer id, String title, DateTime datetime, String description, ArrayList<Artist> artist, Venue venue) {
		this.id = id;
		this.title = title;
		this.datetime = datetime;
		this.description = description;
		this.artist = artist;
		this.venue = venue;
	}

	public Event(Integer id, String title, DateTime datetime, ArrayList<Artist> artist, Venue venue) {
		this.id = id;
		this.title = title;
		this.datetime = datetime;
		this.artist = artist;
		this.venue = venue;
	}

	public Event() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(DateTime datetime) {
		this.datetime = datetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Artist> getArtist() {
		return artist;
	}

	public void setArtist(ArrayList<Artist> artist) {
		this.artist = artist;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", datetime="
				+ datetime + ", description=" + description + ", artist="
				+ artist + ", venue=" + venue + "]";
	}
	
		
}