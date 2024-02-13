package com.example.demo.service;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProductById(Long id);

}