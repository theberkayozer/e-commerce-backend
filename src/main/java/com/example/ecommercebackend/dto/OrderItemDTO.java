package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class OrderItemDTO {
    @JsonIgnore
    private Integer id;

    private int piece; // adet
    private double totalAmount; // adet * birim fiyat

    private ProductDTO product;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer id, int piece, double totalAmount, ProductDTO product) {
        this.id = id;
        this.piece = piece;
        this.totalAmount = totalAmount;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
