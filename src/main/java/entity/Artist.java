package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity 
@Table(name="Artist",
	uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})

public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// nullable=true per i casi un cui lo sia
	@Column(name="id", nullable=true, unique=false)
	private String id;

	@Column(name="name", nullable=true)
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
