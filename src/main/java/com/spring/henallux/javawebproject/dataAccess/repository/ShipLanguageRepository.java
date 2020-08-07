package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.CategoryLanguageEntity;
import com.spring.henallux.javawebproject.dataAccess.entity.ShipLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipLanguageRepository extends JpaRepository<ShipLanguageEntity, String>{
	Optional<ShipLanguageEntity> findByShipIdAndLanguageId(int shipId, int languageId);
}

