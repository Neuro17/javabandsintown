package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Venue",
		uniqueConstraints={@UniqueConstraint(columnNames={"latitude","longitude"})})

public class Venue {
	
	@Column(name="latitude", nullable=false)
	private double latitude;

	@Column(name="longitude", nullable=false)
	private double longitude;
	
	@Column(name="name", nullable=true)
	private String name;
	
	@Column(name="region", nullable=true)
	private String region;
	
	@Column(name="country", nullable=true)
	private String country;
	
	@Column(name="city", nullable=true)
	private String city;
	
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