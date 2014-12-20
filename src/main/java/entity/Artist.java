package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
create table if not exists concerts.artists(
	artist_name varchar(25) not null primary key,
	artist_id int unsigned,
	constraint unique(artist_id));
*/

@Entity 
@Table(name="artists")

public class Artist {

	@Id
	@Column(name="artist_name", nullable=true)
	private String name;
	
	@Column(name="artist_id", nullable=true, unique=false)
	private int id;
	
	public Artist(String name, String id){
		this.name = name;
		this.id = Integer.parseInt(id);
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
		return Integer.toString(id);
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	@Override
	public String toString() {
		return "Bandsintown artist [name=" + name + ", id=" + id + "]";
	}

}
