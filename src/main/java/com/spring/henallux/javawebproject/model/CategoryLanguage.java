package com.spring.henallux.javawebproject.model;

import java.util.List;

public class CategoryLanguage {
	private Integer id;
	private String description;

	private Category category;
	private Language language;

	private List<ShipLanguage> shipLanguages;

	public CategoryLanguage() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setShipLanguages(List<ShipLanguage> shipLanguages) {
		this.shipLanguages = shipLanguages;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public Language getLanguage() {
		return language;
	}

	public List<ShipLanguage> getShipLanguages() {
		return shipLanguages;
	}
}
