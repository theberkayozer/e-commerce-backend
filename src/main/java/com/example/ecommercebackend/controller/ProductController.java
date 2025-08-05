package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.dto.ProductDTO;
import com.example.ecommercebackend.entity.ProductEntity;
import com.example.ecommercebackend.repository.ProductRepository;
import com.example.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    // *********************** GET **********************
    @GetMapping("/get/all")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> allProducts= productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Integer id){
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }



}
