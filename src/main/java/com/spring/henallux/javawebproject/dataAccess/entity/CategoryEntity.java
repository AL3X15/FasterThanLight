package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;

	public CategoryEntity() {
	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
