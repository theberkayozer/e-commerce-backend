package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
