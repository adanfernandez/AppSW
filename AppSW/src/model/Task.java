package model;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String title;

	private String location;

	private String description;

	private Date expirationDate;

	@NotNull
	private int id_state;

	public Task() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getId_state() {
		return id_state;
	}

	public void setId_state(int id_state) {
		this.id_state = id_state;
	}

}