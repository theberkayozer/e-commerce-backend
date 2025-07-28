package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterDTO {

    @NotBlank(message = "Ad alanı boş olamaz")
    private String name;
    @NotBlank(message = "Soyad alanı boş olamaz")
    private String surname;
    @NotBlank(message = "Email alanı boş olamaz")
    @Email
    private String email;
    @NotBlank(message = "Şifre alanı boş olamaz")
    private String password;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public @NotBlank(message = "Ad alanı boş olamaz") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Ad alanı boş olamaz") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Soyad alanı boş olamaz") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Soyad alanı boş olamaz") String surname) {
        this.surname = surname;
    }

    public @NotBlank(message = "Email alanı boş olamaz") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email alanı boş olamaz") @Email String email) {
        this.email = email;
    }

    public @NotBlank(message = "Şifre alanı boş olamaz") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Şifre alanı boş olamaz") String password) {
        this.password = password;
    }
}
