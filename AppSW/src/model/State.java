package model;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class State {
	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private int place;

	@NotNull
	private String name;

	@NotNull
	private long panelId;
	
	private boolean deleted;

	public State() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPanelId() {
		return panelId;
	}

	public void setPanelId(long panelId) {
		this.panelId = panelId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	

}
