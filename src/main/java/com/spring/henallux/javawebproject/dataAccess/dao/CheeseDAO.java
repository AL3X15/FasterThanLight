package com.spring.henallux.javawebproject.dataAccess.dao;

/*
@Component
public class CheeseDAO {
	private final CheeseRepository dataAccess;
	private final ProviderConverter mapper;

	@Autowired
	public CheeseDAO(CheeseRepository cheeseRepository, ProviderConverter mapper) {
		this.dataAccess = cheeseRepository;
		this.mapper = mapper;
	}

	public Collection<Cheese> findAllCheese() {
		return dataAccess.findAll().stream().map(mapper::cheeseEntityToCheeseModel).collect(Collectors.toList());
	}

	public Cheese findCheese(int id) throws CheeseNotFound {
		Optional<CheeseEntity> cheeseEntity = dataAccess.findById(id);

		if (!cheeseEntity.isPresent()) throw new CheeseNotFound();
		return mapper.cheeseEntityToCheeseModel(cheeseEntity.get());
	}
}
*/