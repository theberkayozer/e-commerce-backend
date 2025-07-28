package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.CategoryDTO;
import com.example.ecommercebackend.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryEntity dtoToEntity(CategoryDTO categoryDTO){
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryName(categoryDTO.getCategoryName());
        entity.setCategoryDescription(categoryDTO.getCategoryDescription());

        return entity;
    }

    public CategoryDTO entityToDto(CategoryEntity categoryEntity){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryName(categoryEntity.getCategoryName());
        dto.setCategoryDescription(categoryEntity.getCategoryDescription());
        return dto;
    }

}
