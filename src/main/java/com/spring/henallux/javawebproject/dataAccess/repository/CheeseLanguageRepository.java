package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.CheeseLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheeseLanguageRepository extends JpaRepository<CheeseLanguageEntity, String> {
	Optional<CheeseLanguageEntity> findByCheeseIdAndLanguageId(int cheeseId, int languageId);
}
