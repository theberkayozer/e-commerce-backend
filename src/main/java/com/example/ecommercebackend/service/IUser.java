package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.AddressDTO;
import com.example.ecommercebackend.dto.OrderDTO;
import com.example.ecommercebackend.dto.PasswordUpdateDTO;
import com.example.ecommercebackend.dto.UserProfileDTO;
import org.apache.catalina.User;

import java.util.List;

public interface IUser {

    UserProfileDTO updateProfile(String email ,UserProfileDTO newProfile);
    void updatePassword(String password, PasswordUpdateDTO userPassword);
    UserProfileDTO getProfile(String email);
    List<AddressDTO> getAddresses(String email);
    List<OrderDTO> getOrders(String email);
}
