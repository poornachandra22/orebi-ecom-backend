package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private UUID categoryId;
    private String brand;
    private String modelNumber;
    private String color;
    private BigDecimal weight;
    private String dimensions;
    private String material;
    private String manufacturer;
    private String originCountry;
    private String warranty;
    private LocalDate releaseDate;
    private BigDecimal rating;
    private boolean isFeatured;
    private boolean isActive;
    private String imageUrl;
}
