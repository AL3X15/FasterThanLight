package com.spring.henallux.javawebproject.model;

public class CheeseLanguage {
	private Integer id;
	private String description;

	private Cheese cheese;
	private Language language;

	public CheeseLanguage() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
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

	public Cheese getCheese() {
		return cheese;
	}

	public Language getLanguage() {
		return language;
	}
}
