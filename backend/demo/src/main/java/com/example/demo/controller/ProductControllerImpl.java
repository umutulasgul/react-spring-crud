package com.example.demo.controller;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.factory.ResponseFactory;
import com.example.demo.model.Response;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerImpl implements ProductController{
    
    private final ProductService productService;
    private final ResponseFactory responseFactory;
    public ProductControllerImpl(ProductService productService, ResponseFactory responseFactory) {
        this.productService = productService;
        this.responseFactory = responseFactory;
    }

    @Override
    public ResponseEntity<Response> addProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        productService.addProduct(productRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getProducts() {
        return responseFactory.createResponse(productService.getProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getById(Long id) {
        return responseFactory.createResponse(productService.getProductById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateById(Long id, @Valid ProductRequestDTO productRequestDTO) {
        return responseFactory.createResponse(productService.updateProduct(id,productRequestDTO),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteById(Long id) {
        productService.deleteProductById(id);
        return responseFactory.createResponse("success", HttpStatus.OK);
    }
}