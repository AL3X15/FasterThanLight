package com.spring.henallux.javawebproject.model;

public class CategoryLanguage {
	private Integer id;
	private String description;

	private Category category;
	private Language language;

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
}
