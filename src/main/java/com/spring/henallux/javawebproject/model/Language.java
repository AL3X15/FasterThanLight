package com.spring.henallux.javawebproject.model;

import java.util.Collection;

public class Language {
	private Integer id;
	private String name;

	private Collection<CheeseLanguage> descriptions;

	public Language() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescriptions(Collection<CheeseLanguage> descriptions) {
		this.descriptions = descriptions;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<CheeseLanguage> getDescriptions() {
		return descriptions;
	}
}
