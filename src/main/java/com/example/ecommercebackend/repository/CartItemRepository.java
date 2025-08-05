package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItemEntity,Integer>{
}
