package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {
	LanguageEntity findByName(String name);
}
