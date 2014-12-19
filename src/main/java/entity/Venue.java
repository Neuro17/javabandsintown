package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Venue",
	uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
/*
 * `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
`name` varchar(20) DEFAULT NULL,
`region` varchar(20) DEFAULT NULL,
`country` varchar(20) DEFAULT NULL,
`city` varchar(20) DEFAULT NULL,
`latitude` float default null,
`longitude` float default null,
*/
public class Venue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
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