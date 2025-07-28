package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.UserDTO;
import com.example.ecommercebackend.entity.UserEntity;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserDTO entityToDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setBalance(entity.getBalance());

        return dto;

    }

    public UserEntity dtoToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setBalance(dto.getBalance());

        return entity;
    }
}
