package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductCategoryResponse {
    private UUID id;
    private String name;
    private String description;
    private UUID parentCategoryId;
    private String parentCategoryName;
    private String imageUrl;
}
