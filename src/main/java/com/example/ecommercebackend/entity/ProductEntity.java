package com.example.ecommercebackend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private double price;
    private int stock;
    private String imageUrl;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;


    @OneToMany(mappedBy = "product")
    private List<CartItemEntity> cardItems;

    public ProductEntity(Integer id, String name, double price, int stock, String imageUrl, String description, CategoryEntity category, List<OrderItemEntity> orderItems, List<CartItemEntity> cardItems) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.orderItems = orderItems;
        this.cardItems = cardItems;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


    public List<CartItemEntity> getCardItems() {
        return cardItems;
    }

    public void setCardItems(List<CartItemEntity> cardItems) {
        this.cardItems = cardItems;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductEntity() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
