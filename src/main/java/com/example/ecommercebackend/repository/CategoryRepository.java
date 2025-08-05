package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
