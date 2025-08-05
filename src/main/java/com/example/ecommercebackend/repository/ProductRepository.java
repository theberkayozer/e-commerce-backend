package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.dto.ProductDTO;
import com.example.ecommercebackend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends JpaRepository<ProductEntity ,Integer> {
    ProductEntity getById(Integer id);
    ProductEntity getByName(String name);
    ProductEntity getByNameContainingIgnoreCase(String name);
    List<ProductEntity> getByPriceGreaterThan(double price);

}
