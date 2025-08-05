package com.example.ecommercebackend.service;

import com.example.ecommercebackend.converter.UserConverter;
import com.example.ecommercebackend.dto.UserLoginDTO;
import com.example.ecommercebackend.entity.UserEntity;
import com.example.ecommercebackend.jwt.JwtUtil;
import com.example.ecommercebackend.repository.UserRepository;
import com.example.ecommercebackend.dto.JwtResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService implements IUserLogin {
    @Autowired
    UserConverter converter;
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public JwtResponseDTO login(UserLoginDTO userLogin) {
        Optional<UserEntity> userOpt = repository.findByEmail(userLogin.getEmail());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Kayıtlı Email Bulunamadı.");
        }
        UserEntity user = userOpt.get(); // Optional'dan Entity'e dönüşüm

        if (!passwordEncoder.matches(userLogin.getPassword(),user.getPassword())) {
            throw new RuntimeException("Şifre Yanlış. Lütfen Tekrar Deneyiniz");
        }
        String token = jwtUtil.generateToken(user);
        System.out.println("Giriş Yapılıyor");
        userLogin.setPassword(null);

        return new JwtResponseDTO(token ,user.getEmail(), user.getRole().name());

    }


}