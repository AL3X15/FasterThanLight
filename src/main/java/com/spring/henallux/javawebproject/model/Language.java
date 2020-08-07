package com.spring.henallux.javawebproject.model;

import java.util.Collection;

public class Language {
	private Integer id;
	private String name;

	private Collection<ShipLanguage> descriptionsShip;
	private Collection<CategoryLanguage> descriptionsCategory;

	public Language() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescriptionsShip(Collection<ShipLanguage> descriptionsShip) {
		this.descriptionsShip = descriptionsShip;
	}

	public void setDescriptionsCategory(Collection<CategoryLanguage> descriptionsCategory) {
		this.descriptionsCategory = descriptionsCategory;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<ShipLanguage> getDescriptionsShip() {
		return descriptionsShip;
	}

	public Collection<CategoryLanguage> getDescriptionsCategory() {
		return descriptionsCategory;
	}
}
