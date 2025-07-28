package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public class UserProfileDTO {
    @JsonIgnore
    private Integer id;
    private String name;
    private String surname;

    @PositiveOrZero
    private double balance;

    private List<AddressDTO> addresses;
    private List<OrderDTO> orderList;

    public UserProfileDTO(Integer id, String name, String surname, double balance, List<AddressDTO> addresses, List<OrderDTO> orderList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.addresses = addresses;
        this.orderList = orderList;

    }

    public UserProfileDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @PositiveOrZero
    public double getBalance() {
        return balance;
    }

    public void setBalance(@PositiveOrZero double balance) {
        this.balance = balance;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

}
