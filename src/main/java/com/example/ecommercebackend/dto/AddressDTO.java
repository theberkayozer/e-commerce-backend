package com.example.ecommercebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressDTO {

    @JsonIgnore
    private Integer id;
    private String street;
    private String city;
    private String country;
    private Integer postalcode;

    public AddressDTO() {
    }

    public AddressDTO(Integer id, String street, String city, String country, Integer postalcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalcode = postalcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
