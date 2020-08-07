package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.CheeseEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.CheeseRepository;
import com.spring.henallux.javawebproject.exceptions.CheeseNotFound;
import com.spring.henallux.javawebproject.model.Cheese;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

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
