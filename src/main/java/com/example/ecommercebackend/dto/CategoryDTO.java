package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryDTO {
    @JsonIgnore
    private Integer id;
    private String categoryName;
    private String categoryDescription;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
