package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, String> {
	List<LineEntity> findByOrderId(int orderId);
}
