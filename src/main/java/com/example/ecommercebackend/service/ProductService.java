package com.example.ecommercebackend.service;

import com.example.ecommercebackend.converter.ProductConverter;
import com.example.ecommercebackend.dto.ProductDTO;
import com.example.ecommercebackend.entity.ProductEntity;
import com.example.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProduct{

    @Autowired
    ProductRepository repository;

    @Autowired
    ProductConverter converter;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntityList = repository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity product : productEntityList){
            productDTOList.add(converter.entityToDto(product));
        }

        return productDTOList;
    }


    @Override
    public ProductDTO getProductById(Integer id) {
        ProductEntity productEntity = repository.getById(id);

        return converter.entityToDto(productEntity);
    }

    @Override
    public ProductDTO getProductByName(String name) {
        ProductEntity productEntity = repository.getByName(name);
        return converter.entityToDto(productEntity);
    }


    @Override
    public List<ProductDTO> getAllProductGreaterThan(double price) {
        List<ProductEntity> productEntityList = repository.getByPriceGreaterThan(price);
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (ProductEntity product : productEntityList){
            productDTOList.add(converter.entityToDto(product));
        }
        return productDTOList;
    }


}
