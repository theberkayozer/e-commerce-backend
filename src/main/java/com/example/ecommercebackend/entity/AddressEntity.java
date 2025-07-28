package com.example.ecommercebackend.entity;

import jakarta.persistence.*;


@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String street;
    private String city;
    private String country;
    private Integer postalcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AddressEntity(String street, String city, String country, Integer postalcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalcode = postalcode;
    }

    public AddressEntity() {
    }

    public Integer getId() {
        return id;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }
}
