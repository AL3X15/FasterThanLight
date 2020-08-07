package com.spring.henallux.javawebproject.dataAccess.dao;

/*
@Component
public class CheeseLanguageDAO {
	private final ProviderConverter mapper;
	private final CheeseLanguageRepository dataAccess;
	private final LanguageRepository languageRepository;

	@Autowired
	public CheeseLanguageDAO(CheeseLanguageRepository dataAccess,
	                         LanguageRepository languageRepository,
	                         ProviderConverter mapper) {
		this.dataAccess = dataAccess;
		this.languageRepository = languageRepository;
		this.mapper = mapper;
	}

	public CheeseLanguage findCheese(int cheeseId, Locale locale) throws Exception {
		String language;
		if (locale.getLanguage().equals("fr")) language = "français";
		else language = "english";

		int languageId = languageRepository.findByName(language).getId();

		Optional<CheeseLanguageEntity> cheeseLanguage = dataAccess.findByCheeseIdAndLanguageId(cheeseId, languageId);

		if (!cheeseLanguage.isPresent()) throw new Exception(); //TODO better exception

		return mapper.cheeseLanguageEntityToCheeseLanguageModel(cheeseLanguage.get());
	}
}
*/