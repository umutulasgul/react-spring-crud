package com.example.demo.controller;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProductController {

    @PostMapping
    ResponseEntity<Response> addProduct(ProductRequestDTO productRequestDTO);

    @GetMapping
    ResponseEntity<Response> getProducts();

    @GetMapping("/{id}")
    ResponseEntity<Response> getById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById(@PathVariable Long id);
}
