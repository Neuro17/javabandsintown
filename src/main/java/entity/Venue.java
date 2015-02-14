package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venues")

public class Venue {
	
	@Id
	@Column(name = "venue_id")
	private int id;
	
	@Column(name = "lat")
	private double latitude;
	
	@Column(name = "lng")
	private double longitude;
	
	@Column(name = "venue_name")
	private String name;
	
	@Column(name = "venue_country")
	private String country;
	
	@Column(name = "venue_city")
	private String city;

	@Column(name = "venue_region")
	private String region;
	
	public Venue(){
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Venue [latitude=" + latitude + ", longitude=" + longitude
				+ ", name=" + name + ", region=" + region + ", country="
				+ country + ", city=" + city + "]";
	}
	
}