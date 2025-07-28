package com.example.ecommercebackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class UserDTO {
    @JsonIgnore
    private Integer id;
    private String name;
    private String surname;
    @NotBlank(message = "Email alanı boş bırakılamaz")
    @Email(message = "Geçerli bir mail adresi giriniz")
    private String email;
    @PositiveOrZero
    private double balance;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, String email,  double balance) {
        this.name = name;
        this.surname = surname;
        this.email = email;

        this.balance = balance;
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

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }
}
