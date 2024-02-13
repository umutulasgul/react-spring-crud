package com.example.demo.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO{

    private Long id;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private String description;
}