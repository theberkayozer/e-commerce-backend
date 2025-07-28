package com.example.ecommercebackend;

import com.example.ecommercebackend.entity.AddressEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackendApplication.class, args);


        AddressEntity entity = new AddressEntity();
        entity.setCity("berkay");
        entity.getCity();

    }



}
