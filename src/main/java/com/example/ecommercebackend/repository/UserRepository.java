package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity ,Integer> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
