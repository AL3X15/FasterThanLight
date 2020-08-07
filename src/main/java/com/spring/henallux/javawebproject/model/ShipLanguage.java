package com.spring.henallux.javawebproject.model;

public class ShipLanguage {
	private Integer id;
	private String description;

	private Ship ship;
	private Language language;

	public ShipLanguage() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Ship getShip() {
		return ship;
	}

	public Language getLanguage() {
		return language;
	}
}
