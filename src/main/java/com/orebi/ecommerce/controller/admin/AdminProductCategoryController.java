package com.orebi.ecommerce.controller.admin;

import com.orebi.ecommerce.entity.ProductCategory;
import com.orebi.ecommerce.model.ProductCategoryRequest;
import com.orebi.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/product-categories")
public class AdminProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategoryRequest categoryRequest) {
        return productCategoryService.createProductCategory(categoryRequest);
    }

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategoriesObject();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable UUID id) {
        return productCategoryService.getProductCategoryObjectById(id);
    }

    @PutMapping("/{id}")
    public ProductCategory updateProductCategory(@PathVariable UUID id, @RequestBody ProductCategoryRequest categoryRequest) {
        return productCategoryService.updateProductCategory(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable UUID id) {
        productCategoryService.deleteProductCategory(id);
    }
}
