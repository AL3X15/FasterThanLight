package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.CategoryLanguageDAO;
import com.spring.henallux.javawebproject.model.CategoryLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CategoryLanguageServices {
	private final CategoryLanguageDAO dao;

	@Autowired
	public CategoryLanguageServices(CategoryLanguageDAO dao) {
		this.dao = dao;
	}

	public CategoryLanguage findCheese(int categoryId, Locale locale) throws Exception {
		return dao.findCategory(categoryId, locale);
	}
}
