package com.example.ecommercebackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;



    public CartItemEntity() {
    }

    public CartItemEntity(UserEntity user, ProductEntity product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

