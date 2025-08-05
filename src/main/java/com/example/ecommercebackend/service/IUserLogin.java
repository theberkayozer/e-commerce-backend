package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.JwtResponseDTO;
import com.example.ecommercebackend.dto.UserLoginDTO;

public interface IUserLogin {

    JwtResponseDTO login(UserLoginDTO userLogin);
}
