package com.example.demo.service;

import com.example.demo.dto.ProductRequestDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    public void addProduct(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO, Product.class);
        productRepository.save(product);
    }
    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) throw new ProductNotFoundException();
        return products.stream()
            .map(product -> modelMapper.map(product, ProductResponseDTO.class))
            .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = findProductById(id);
        return modelMapper.map(product,ProductResponseDTO.class);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = findProductById(id);
        modelMapper.map(productRequestDTO, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    public void deleteProductById(Long id) {
        findProductById(id);
        productRepository.deleteById(id);
    }
    private Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
