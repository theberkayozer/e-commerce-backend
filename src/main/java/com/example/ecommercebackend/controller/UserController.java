package com.example.ecommercebackend.controller;


import com.example.ecommercebackend.dto.*;
import com.example.ecommercebackend.jwt.JwtUtil;

import com.example.ecommercebackend.service.UserLoginService;
import com.example.ecommercebackend.service.UserRegisterService;
import com.example.ecommercebackend.service.UserService;
import jakarta.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRegisterService registerService;
    @Autowired
    UserLoginService loginService;
    @Autowired
    UserService service;
    @Autowired
    JwtUtil jwtUtil;

    // **************************************** Post Api **********************************************


    @PostMapping("/login") // Giriş İşlemi
    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserLoginDTO loginDTO) {
        JwtResponseDTO response = loginService.login(loginDTO);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register") // Kayıt İşlemi
    public ResponseEntity<UserRegisterDTO> registerDTO(@RequestBody UserRegisterDTO registerUser) {
        UserRegisterDTO registerUserDto = registerService.userRegister(registerUser);
        registerUserDto.setPassword(null);
        return new ResponseEntity<>(registerUserDto, HttpStatus.CREATED);
    }
    // **************************************** Get Api **********************************************
    @GetMapping("/profile") // Profil Görüntüleme
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserProfileDTO> getProfile(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {

        // Login olan kullanıcının email’i  user nesnesinde mevcut
        String email = user.getUsername();

        //  Profil getirilir
        UserProfileDTO profile = service.getProfile(email);

        return ResponseEntity.ok(profile);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user){

        String email = user.getUsername();

        List<AddressDTO> addresses = service.getAddresses(email);

        return ResponseEntity.ok(addresses);
    }
        @GetMapping("/orders")
        public ResponseEntity<List<OrderDTO>> getOrders(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user){

            String email = user.getUsername();

            List<OrderDTO> orders = service.getOrders(email);

            return ResponseEntity.ok(orders);
        }





    // **************************************** Update Api **********************************************

    @PatchMapping("/update/profile")
    public ResponseEntity<UserProfileDTO> updateProfile(@RequestBody UserProfileDTO userProfileDTO, @RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtil.extractEmail(token);
        UserProfileDTO updatedprofile = service.updateProfile(email, userProfileDTO);

        return ResponseEntity.ok(updatedprofile);
    }

    @PatchMapping("/update/password")
    public ResponseEntity<String> updatePassword(@Valid @RequestBody PasswordUpdateDTO newPassword, @RequestHeader("Authorization") String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Token eksik veya format hatalı");
        }
        String token = jwtUtil.extractEmail(authHeader).replace("Bearer ", "");

        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Oturum süresi dolmuştur, tekrar giriş yapınız");

        }
        String email = jwtUtil.extractEmail(token);

        service.updatePassword(email, newPassword);

        return ResponseEntity.ok("Şifre başarıyla güncellendi");
    }


















   /* @GetMapping("/profile") **JWT FİLTER OLMADAN YAZILAN KOD**
    public ResponseEntity<UserProfileDTO> getProfile( @RequestHeader("Authorization") String authHeader){
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String token = authHeader.replace("Bearer ", "");
        if(!jwtUtil.validateToken(token)){
            return ResponseEntity.status(401).build();
        }
        String email = jwtUtil.extractEmail(token);
        UserProfileDTO profile = service.getProfile(email);

        return  ResponseEntity.ok(profile);
    }
    */
}
