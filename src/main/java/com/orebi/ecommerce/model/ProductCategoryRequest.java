package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductCategoryRequest {
    private String name;
    private String description;
    private UUID parentCategoryId;
    private String imageUrl;
}
