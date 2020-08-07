package com.spring.henallux.javawebproject.dataAccess.entity;

import com.spring.henallux.javawebproject.model.Category;

import javax.persistence.*;

@Entity
@Table(name = "category_language")
public class CategoryLanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description")
	private String description;

	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@ManyToOne
	private CategoryEntity category;
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	@ManyToOne
	private LanguageEntity language;

	public CategoryLanguageEntity() {
	}

	//Setters section
	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public LanguageEntity getLanguage() {
		return language;
	}
}
