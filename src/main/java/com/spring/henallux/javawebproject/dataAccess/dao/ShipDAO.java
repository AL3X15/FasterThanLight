package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.ShipEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.ShipRepository;
import com.spring.henallux.javawebproject.exceptions.ShipNotFound;
import com.spring.henallux.javawebproject.model.Ship;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShipDAO {
	private final ShipRepository dataAccess;
	private final ProviderConverter mapper;

	@Autowired
	public ShipDAO(ShipRepository shipRepository, ProviderConverter mapper) {
		this.dataAccess = shipRepository;
		this.mapper = mapper;
	}

	public Collection<Ship> findAllShip() {
		return dataAccess.findAll().stream().map(mapper::shipEntityToShipModel).collect(Collectors.toList());
	}

	public Ship findShip(int id) throws ShipNotFound {
		Optional<ShipEntity> shipEntity = dataAccess.findById(id);

		if (!shipEntity.isPresent()) throw new ShipNotFound();
		return mapper.shipEntityToShipModel(shipEntity.get());
	}

	public Collection<Ship>findByCategory(int id){
		return dataAccess.findByCategoryId(id).stream().map(mapper::shipEntityToShipModel).collect(Collectors.toList());
	}

}