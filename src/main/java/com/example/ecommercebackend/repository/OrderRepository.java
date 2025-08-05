package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
}
