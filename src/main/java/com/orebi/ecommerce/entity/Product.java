package com.orebi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

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
    private boolean isFeatured = false;
    private boolean isActive = true;
    private String imageUrl;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
