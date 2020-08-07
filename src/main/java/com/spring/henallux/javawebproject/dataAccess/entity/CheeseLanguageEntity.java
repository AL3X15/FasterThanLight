package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "cheese_language")
public class CheeseLanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description")
	private String description;

	@JoinColumn(name = "cheese_id", referencedColumnName = "id")
	@ManyToOne
	private CheeseEntity cheese;
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	@ManyToOne
	private LanguageEntity language;

	public CheeseLanguageEntity() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCheese(CheeseEntity cheese) {
		this.cheese = cheese;
	}

	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public CheeseEntity getCheese() {
		return cheese;
	}

	public LanguageEntity getLanguage() {
		return language;
	}
}
