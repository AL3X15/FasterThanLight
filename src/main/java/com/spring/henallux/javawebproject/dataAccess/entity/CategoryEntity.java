package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	public CategoryEntity() {
	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	//Getters section
	public Integer getId() {
		return id;
	}
}
