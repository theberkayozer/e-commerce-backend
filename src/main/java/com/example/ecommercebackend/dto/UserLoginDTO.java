package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @NotBlank(message = "Email alanı boş olamaz")
    @Email
    private String email;
    @NotBlank(message = "Şifre alanı boş olamaz")
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDTO() {
    }

    public @NotBlank(message = "Email alanı boş olamaz") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email alanı boş olamaz") @Email String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
