package model;

import javax.persistence.GeneratedValue;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String title;

	private String location;

	private String description;

	private XMLGregorianCalendar expirationDate;
	
	private boolean deleted;

	@NotNull
	private long stateId;

	public Task() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public XMLGregorianCalendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(XMLGregorianCalendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
}
