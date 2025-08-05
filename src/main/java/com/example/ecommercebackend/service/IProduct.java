package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.ProductDTO;

import java.util.List;

public interface IProduct {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getAllProductGreaterThan(double price);
    ProductDTO getProductById(Integer id);
    ProductDTO getProductByName(String name);

}
