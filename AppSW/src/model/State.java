package model;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class State {
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private int order;

	@NotNull
	private String name;

	@NotNull
	private int id_panel;

	public State() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_panel() {
		return id_panel;
	}

	public void setId_panel(int id_panel) {
		this.id_panel = id_panel;
	}

}
