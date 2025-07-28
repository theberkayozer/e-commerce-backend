package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.UserDTO;
import com.example.ecommercebackend.dto.UserLoginDTO;
import com.example.ecommercebackend.dto.UserProfileDTO;

import java.util.List;

public interface UserService {

     UserDTO addUser(UserDTO user);
     UserLoginDTO login(String email, String password);
     UserDTO deleteUserById(Integer id);
     UserDTO updateUserById(Integer id , UserDTO user);
     UserDTO updateUserBalance(Integer id , double balance);
     boolean hasEnoughBalance(Integer id , double balance);
     UserDTO updateUserEmail(Integer id , String email);
     UserDTO updateUserPassword(Integer id , String password);
     UserProfileDTO getUserOne(Integer id);
     List<UserProfileDTO> getAllUser();

}
