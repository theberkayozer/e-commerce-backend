package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.ProductDTO;
import com.example.ecommercebackend.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO entityToDto(ProductEntity productEntity){
        ProductDTO productDTO= new ProductDTO();
        productDTO.setName(productEntity.getName());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setStock(productEntity.getStock());
        productDTO.setImageUrl(productEntity.getImageUrl());

        return productDTO;
    }
    public ProductEntity dtoToEntity(ProductDTO productDTO){
        ProductEntity productEntity= new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setImageUrl(productDTO.getImageUrl());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStock(productDTO.getStock());


        return productEntity;
    }



}
