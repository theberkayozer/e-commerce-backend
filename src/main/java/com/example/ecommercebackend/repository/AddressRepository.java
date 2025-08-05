package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
}
