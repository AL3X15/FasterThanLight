package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.javawebproject.exceptions.CategoryNotFound;
import com.spring.henallux.javawebproject.model.Category;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoryDAO {
	private final CategoryRepository dataAccess;
	private final ProviderConverter mapper;

	@Autowired
	public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter mapper) {
		this.dataAccess = categoryRepository;
		this.mapper = mapper;
	}

	public Collection<Category> findAllCategory() {
		return dataAccess.findAll().stream().map(mapper::categoryEntityToCategoryModel).collect(Collectors.toList());
	}

	public Category findCategory(int id) throws CategoryNotFound {
		Optional<CategoryEntity> categoryEntity = dataAccess.findById(id);

		if (!categoryEntity.isPresent()) throw new CategoryNotFound();
		return mapper.categoryEntityToCategoryModel(categoryEntity.get());
	}

}