package com.example.ecommercebackend.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date orderDate;
    private double totalAmount;
    public enum Status{
        Hazırlanıyor,
        Kargoda,
        TeslimEdildi
    }
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;

    @OneToMany(mappedBy = "order")
    public List<OrderItemEntity> orderItems;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderEntity(Date orderDate, double totalAmount, UserEntity user, List<OrderItemEntity> orderItems,Status statue) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderItems = orderItems;
        this.status = statue;
    }

    public OrderEntity() {
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }



    public Integer getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public UserEntity getUser() {
        return user;
    }




}
