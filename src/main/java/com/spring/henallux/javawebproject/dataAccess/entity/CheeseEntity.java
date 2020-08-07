package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cheese")
public class CheeseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "price_per_kilo")
	private Double pricePerKilo;
	@Column(name = "name")
	private String name;
	@Column(name = "URL_image")
	private String URLImage;

	@OneToMany(mappedBy = "cheese")
	private Collection<CheeseLanguageEntity> translations;
	@OneToMany(mappedBy = "cheese")
	private Collection<LineEntity> lines;

	public CheeseEntity() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) throws Exception {
		this.name = name;
	}

	public void setPricePerKilo(Double price) throws Exception {
		this.pricePerKilo = price;
	}

	public void setURLImage(String URLImage) {
		this.URLImage = URLImage;
	}

	public void setLineEntities(Collection<LineEntity> lines) {
		this.lines = lines;
	}

	public void setTranslations(Collection<CheeseLanguageEntity> translations) {
		this.translations = translations;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Double getPricePerKilo() {
		return pricePerKilo;
	}

	public String getName() {
		return name;
	}

	public String getURLImage() {
		return URLImage;
	}

	public Collection<LineEntity> getLineEntities() {
		return lines;
	}

	public Collection<CheeseLanguageEntity> getTranslations() {
		return translations;
	}
}
