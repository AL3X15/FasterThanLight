package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.javawebproject.exceptions.CategoryNotFound;
import com.spring.henallux.javawebproject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServices {
	private final CategoryDAO dao;

	@Autowired
	public CategoryServices(CategoryDAO dao) {
		this.dao = dao;
	}

	public Collection<Category> findAll() {
		return dao.findAllCategory();
	}

	public Category find(int id) throws CategoryNotFound {
		return dao.findCategory(id);
	}
}