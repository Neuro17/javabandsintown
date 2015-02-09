package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="artists")

public class Artist {
	@Id
	@Column(name="artist_id")
	private String id;
	
	@Column(name="artist_name")
	private String name;
	
	public Artist(String name, String id){
		this.name = name;
		this.id = id;
	}
	public Artist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bandsintown artist [name=" + name + ", id=" + id + "]";
	}

}
