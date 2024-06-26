package com.orebi.ecommerce.controller;

import com.orebi.ecommerce.model.ProductCategoryResponse;
import com.orebi.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategoryResponse> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ProductCategoryResponse getProductCategoryById(@PathVariable UUID id) {
        return productCategoryService.getProductCategoryById(id);
    }
}
