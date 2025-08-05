package com.example.ecommercebackend.service;

import com.example.ecommercebackend.converter.AddressConverter;
import com.example.ecommercebackend.converter.OrderConverter;
import com.example.ecommercebackend.converter.UserConverter;
import com.example.ecommercebackend.dto.*;
import com.example.ecommercebackend.entity.AddressEntity;
import com.example.ecommercebackend.entity.OrderEntity;
import com.example.ecommercebackend.entity.OrderItemEntity;
import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUser {
    @Autowired
    UserRepository repository;

    @Autowired
    UserConverter converter;

    @Autowired
    AddressConverter addressConverter;

    @Autowired
     PasswordEncoder passwordEncoder;

    @Autowired
     OrderConverter orderConverter;

    @Override
    public UserProfileDTO updateProfile(String email, UserProfileDTO newProfile) {
        Optional<UserEntity> findUser = repository.findByEmail(email);
        if (findUser.isEmpty()) {
            throw new RuntimeException("Kullanıcı Bulunamadı");
        }
        UserEntity userEntity = findUser.get();
        if (newProfile.getName() != null) {
            userEntity.setName(newProfile.getName());
        }
        if (newProfile.getSurname() != null) {
            userEntity.setSurname(newProfile.getSurname());
        }
        if (newProfile.getBalance() != 0.0) {
            userEntity.setBalance(newProfile.getBalance());
        }
        repository.save(userEntity);

        return converter.entityToDtoProfile(userEntity);
    }

    @Override
    public void updatePassword(String email, PasswordUpdateDTO userPassword) {
        Optional<UserEntity> findUser = repository.findByEmail(email);
        if (findUser.isEmpty()) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
        UserEntity user = findUser.get();
        if (passwordEncoder.matches(userPassword.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Güncel şifreyi yanlış girdiniz.Tekrar deneyiniz.");
        }

        if (!userPassword.getNewPassword().equals(userPassword.getConfirmPassword())) {
            throw new RuntimeException("Yeni şifreyi uyumlu girmediniz. Tekrar deneyiniz.");
        }
        if (!passwordEncoder.matches(userPassword.getNewPassword(), user.getPassword())) {
            throw new RuntimeException("Eski şifre ve yeni şifre aynı olamaz.");
        }
        user.setPassword(passwordEncoder.encode(userPassword.getNewPassword()));
        repository.save(user);

        System.out.println("Şifre güncellendi");
    }

    @Override
    public UserProfileDTO getProfile(String email) {
        Optional<UserEntity> profile = repository.findByEmail(email);

        UserEntity profileEntity = profile.get();


        return converter.entityToDtoProfile(profileEntity);


    }

    @Override
    public List<AddressDTO> getAddresses(String email) {
        Optional<UserEntity> profile = repository.findByEmail(email);
        if (profile.isEmpty()) {
            throw new RuntimeException("Email bulunamadı");
        }
        UserEntity userProfileEntity = profile.get();
        List<AddressEntity> addressEntityList = userProfileEntity.getAddresses();
        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (AddressEntity ae : addressEntityList) {
            addressDTOList.add(addressConverter.entityToDto(ae));
        }

        return addressDTOList;
    }

    @Override
    public List<OrderDTO> getOrders(String email) {
        Optional<UserEntity> userEntity = repository.findByEmail(email);
        if (userEntity.isEmpty()) {
            throw new RuntimeException("Kullanıcı bulunamadı");

        }
        UserEntity user = userEntity.get();
        List<OrderEntity> orders = user.getOrders();
        List<OrderItemDTO> orderDTOList = new ArrayList<>();


        for (OrderEntity orderEntity : orders) {

            orderDTOList.add(orderConverter.entityToDto(orderEntity,orderDTOList));
        }


        return orderDTOList;
    }


}
