package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CartItemDTO {

    @JsonIgnore
    private Integer id;
    private int quantity;

    private ProductDTO product;

    public CartItemDTO() {
    }

    public CartItemDTO(Integer id, int quantity, ProductDTO product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public ProductDTO getProducts() {
        return product;
    }

    public void setProducts(ProductDTO products) {
        this.product = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
