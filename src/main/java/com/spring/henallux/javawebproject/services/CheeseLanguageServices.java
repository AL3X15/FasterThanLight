package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.CheeseLanguageDAO;
import com.spring.henallux.javawebproject.model.Cheese;
import com.spring.henallux.javawebproject.model.CheeseLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CheeseLanguageServices {
	private final CheeseLanguageDAO dao;

	@Autowired
	public CheeseLanguageServices(CheeseLanguageDAO dao) {
		this.dao = dao;
	}

	public CheeseLanguage findCheese(int cheeseId, Locale locale) throws Exception {
		return dao.findCheese(cheeseId, locale);
	}
}
