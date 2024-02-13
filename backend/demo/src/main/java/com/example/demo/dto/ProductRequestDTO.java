package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO{
    @NotBlank(message = "Please ensure you provide a name for the product.")
    private String name;
    @NotBlank(message = "Please ensure you provide a category for the product.")
    private String category;
    @NotBlank(message = "Please ensure you provide a brand for the product.")
    private String brand;
    @NotNull(message = "Please ensure you provide a price for the product.")
    private BigDecimal price;
    @NotBlank(message = "Please ensure you provide a description for the product.")
    private String description;
}
