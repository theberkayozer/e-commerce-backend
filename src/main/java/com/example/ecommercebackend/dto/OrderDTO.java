package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;

public class OrderDTO {
    @JsonIgnore
    private Integer id;
    private Date orderDate;
    private double totalAmount;
    public enum Status{
        Hazırlanıyor,
        Kargoda,
        TeslimEdildi
    }
    private Status status;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Date orderDate, double totalAmount, List<OrderItemDTO> items,Status status) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.items = items;
        this.status=status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
