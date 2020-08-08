package com.spring.henallux.javawebproject.model;

import java.util.Collection;

public class Category {
	private Integer id;
	private String name;
	private Collection<Ship> ships;

	//Setters section
	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShips(Collection<Ship> ships) {
		this.ships = ships;
	}

	//Getters section
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Collection<Ship> getShips() {
		return ships;
	}
}
