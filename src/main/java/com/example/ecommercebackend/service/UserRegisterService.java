package com.example.ecommercebackend.service;

import com.example.ecommercebackend.converter.UserConverter;
import com.example.ecommercebackend.dto.UserRegisterDTO;
import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.repository.UserRepository;
import com.example.ecommercebackend.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements IUserRegister {
    @Autowired
    UserConverter converter;

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterDTO userRegister(UserRegisterDTO user) {
        UserEntity userEntity = converter.dtoToEntityRegister(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedUser = repository.save(userEntity);
        UserRegisterDTO result = converter.entityToDtoRegister(savedUser);
        result.setPassword(null);
        return result;
    }
}
