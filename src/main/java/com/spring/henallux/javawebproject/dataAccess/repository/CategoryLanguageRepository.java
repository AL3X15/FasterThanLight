package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.CategoryLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryLanguageRepository extends JpaRepository<CategoryLanguageEntity, String>{
	Optional<CategoryLanguageEntity> findByCategoryIdAndLanguageId(int categoryId, int languageId);
}
