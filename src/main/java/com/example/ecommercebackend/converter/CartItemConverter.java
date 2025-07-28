package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.CartItemDTO;
import com.example.ecommercebackend.entity.CartItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {
    @Autowired
    private ProductConverter productConverter;
    public CartItemDTO entityToDto(CartItemEntity cartItemEntity ){
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setQuantity(cartItemEntity.getQuantity());
        cartItemDTO.setProducts(productConverter.entityToDto(cartItemEntity.getProduct()));

        return cartItemDTO;
    }


    public CartItemEntity dtoToEntity(CartItemDTO cartItemDTO){
        CartItemEntity entity = new CartItemEntity();
        entity.setQuantity(cartItemDTO.getQuantity());
        entity.setProduct(productConverter.dtoToEntity(cartItemDTO.getProducts()));

        return entity;

    }







}
