package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.javawebproject.dataAccess.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, String>{
	Optional<ShipEntity> findById(int id);
	List<ShipEntity> findByCategoryId(int id);
}