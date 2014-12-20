package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="venues")
/*

create table if not exists concerts.venues(
	venue_id int unsigned not null primary key AUTO_INCREMENT,
	lat double not null,
	lng double not null,
	venue_name varchar(50) not null,
	country varchar(20) not null,
	city varchar(20) not null,
	constraint unique_lat_lng unique(lat, lng)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

*/
public class Venue {
	
	@Id
	@Column(name="venue_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="lat", nullable=false)
	private double latitude;

	@Column(name="lng", nullable=false)
	private double longitude;
	
	@Column(name="venue_name", nullable=false)
	private String name;
	
	@Column(name="country", nullable=false)
	private String country;
	
	@Column(name="city", nullable=false)
	private String city;

	private String region;
	
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