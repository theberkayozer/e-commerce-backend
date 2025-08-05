package com.example.ecommercebackend.converter;

import com.example.ecommercebackend.dto.UserDTO;
import com.example.ecommercebackend.dto.UserLoginDTO;
import com.example.ecommercebackend.dto.UserProfileDTO;
import com.example.ecommercebackend.dto.UserRegisterDTO;
import com.example.ecommercebackend.entity.UserEntity;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    public UserDTO entityToDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setBalance(entity.getBalance());

        return dto;

    }

    public UserProfileDTO entityToDtoProfile(UserEntity entity){
        UserProfileDTO dto = new UserProfileDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setBalance(entity.getBalance());

        return dto;

    }

    public UserEntity dtoToEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBalance(dto.getBalance());

        return entity;
    }

    public UserRegisterDTO entityToDtoRegister(UserEntity entity){
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());

        return dto;

    }

    public UserEntity dtoToEntityRegister(UserRegisterDTO registerUser){
        UserEntity entity = new UserEntity();
        entity.setName(registerUser.getName());
        entity.setSurname(registerUser.getSurname());
        entity.setEmail(registerUser.getEmail());
        entity.setPassword(registerUser.getPassword());
        return entity;

    }
    public UserLoginDTO entityToDtoLogin(UserEntity entity){
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setEmail(entity.getEmail());
        userLoginDTO.setPassword(entity.getPassword());

        return userLoginDTO;

    }
    public UserEntity dtoToEntityLogin(UserLoginDTO userLoginDto){
        UserEntity userLoginEntity = new UserEntity();
        userLoginEntity.setEmail(userLoginDto.getEmail());
        userLoginEntity.setPassword(userLoginDto.getPassword());

        return userLoginEntity;

    }
}
