package com.example.ecommercebackend.dto;

import jakarta.validation.constraints.NotBlank;

public class PasswordUpdateDTO {

    @NotBlank(message = "Eski şifre boş olamaz")
    private String oldPassword;

    @NotBlank(message = "Yeni şifre boş olamaz")
    private String newPassword;

    @NotBlank(message = "Şifre tekrarı boş olamaz")
    private String confirmPassword;

    public @NotBlank(message = "Eski şifre boş olamaz") String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(@NotBlank(message = "Eski şifre boş olamaz") String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public @NotBlank(message = "Yeni şifre boş olamaz") String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(@NotBlank(message = "Yeni şifre boş olamaz") String newPassword) {
        this.newPassword = newPassword;
    }

    public @NotBlank(message = "Şifre tekrarı boş olamaz") String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank(message = "Şifre tekrarı boş olamaz") String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
