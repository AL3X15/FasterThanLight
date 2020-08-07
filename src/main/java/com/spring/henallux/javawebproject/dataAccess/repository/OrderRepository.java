package com.spring.henallux.javawebproject.dataAccess.repository;

import com.spring.henallux.javawebproject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
	List<OrderEntity> findByCustomerUsername(String username);

	Optional<OrderEntity> findById(int id);
}
