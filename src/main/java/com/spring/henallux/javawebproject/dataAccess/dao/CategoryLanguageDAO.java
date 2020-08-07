package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.CategoryLanguageEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.CategoryLanguageRepository;
import com.spring.henallux.javawebproject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.javawebproject.exceptions.CategoryLanguageNotFound;
import com.spring.henallux.javawebproject.model.Category;
import com.spring.henallux.javawebproject.model.CategoryLanguage;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryLanguageDAO {
	private final ProviderConverter mapper;
	private final CategoryLanguageRepository dataAccess;
	private final LanguageRepository languageRepository;

	@Autowired
	public CategoryLanguageDAO(CategoryLanguageRepository dataAccess,
	                           LanguageRepository languageRepository,
	                           ProviderConverter mapper) {
		this.dataAccess = dataAccess;
		this.languageRepository = languageRepository;
		this.mapper = mapper;
	}


	public CategoryLanguage findCategory(int categoryId, Locale locale) throws Exception {
		String language;
		if (locale.getLanguage().equals("fr")) language = "français";
		else language = "english";

		int languageId = languageRepository.findByName(language).getId();

		Optional<CategoryLanguageEntity> categoryLanguage = dataAccess.findByCategoryIdAndLanguageId(categoryId, languageId);

		if (!categoryLanguage.isPresent()) throw new CategoryLanguageNotFound();

		return mapper.categoryLanguageEntityToCategoryLanguageModel(categoryLanguage.get());
	}

}