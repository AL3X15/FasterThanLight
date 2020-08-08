package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.ShipLanguageEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.javawebproject.dataAccess.repository.ShipLanguageRepository;
import com.spring.henallux.javawebproject.exceptions.ShipLanguageNotFound;
import com.spring.henallux.javawebproject.model.ShipLanguage;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class ShipLanguageDAO {
	private final ProviderConverter mapper;
	private final ShipLanguageRepository dataAccess;
	private final LanguageRepository languageRepository;

	@Autowired
	public ShipLanguageDAO(ShipLanguageRepository dataAccess,
	                         LanguageRepository languageRepository,
	                         ProviderConverter mapper) {
		this.dataAccess = dataAccess;
		this.languageRepository = languageRepository;
		this.mapper = mapper;
	}

	public ShipLanguage findShip(int shipId, Locale locale) throws Exception {
		String language;
		if (locale.getLanguage().equals("fr")) language = "français";
		else language = "english";

		int languageId = languageRepository.findByName(language).getId();

		Optional<ShipLanguageEntity> shipLanguage = dataAccess.findByShipIdAndLanguageId(shipId, languageId);

		if (!shipLanguage.isPresent()) throw new ShipLanguageNotFound();

		return mapper.shipLanguageEntityToShipLanguageModel(shipLanguage.get());
	}

}