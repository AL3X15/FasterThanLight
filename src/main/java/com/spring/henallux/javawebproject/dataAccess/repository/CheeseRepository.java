package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.CheeseEntity;
import com.spring.henallux.javawebproject.model.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CheeseRepository extends JpaRepository<CheeseEntity, String> {
	Optional<CheeseEntity> findById(int id);
}
