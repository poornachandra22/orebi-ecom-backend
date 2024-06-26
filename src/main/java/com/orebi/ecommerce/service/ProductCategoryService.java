package com.orebi.ecommerce.service;

import com.orebi.ecommerce.entity.ProductCategory;
import com.orebi.ecommerce.model.ProductCategoryRequest;
import com.orebi.ecommerce.model.ProductCategoryResponse;
import com.orebi.ecommerce.repository.ProductCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(ProductCategoryRequest categoryRequest) {
        ProductCategory category = new ProductCategory();
        BeanUtils.copyProperties(categoryRequest, category);
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        return productCategoryRepository.save(category);
    }

    public List<ProductCategory> getAllProductCategoriesObject() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryObjectById(UUID id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Category not found"));
    }

    public ProductCategory updateProductCategory(UUID id, ProductCategoryRequest categoryRequest) {
        ProductCategory existingCategory = getProductCategoryObjectById(id);
        BeanUtils.copyProperties(categoryRequest, existingCategory);
        existingCategory.setUpdatedAt(LocalDateTime.now());
        return productCategoryRepository.save(existingCategory);
    }

    public void deleteProductCategory(UUID id) {
        ProductCategory category = getProductCategoryObjectById(id);
        productCategoryRepository.delete(category);
    }

    public List<ProductCategoryResponse> getAllProductCategories() {
        List<ProductCategory> categories = productCategoryRepository.findAll();
        return categories.stream().map(this::mapToProductCategoryResponse).collect(Collectors.toList());
    }

    public ProductCategoryResponse getProductCategoryById(UUID id) {
        ProductCategory category = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Category not found"));
        return mapToProductCategoryResponse(category);
    }

    private ProductCategoryResponse mapToProductCategoryResponse(ProductCategory category) {
        ProductCategoryResponse response = new ProductCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setParentCategoryId(category.getParentCategory() != null ? category.getParentCategory().getId() : null);
        response.setParentCategoryName(category.getParentCategory() != null ? category.getParentCategory().getName() : null);
        response.setImageUrl(category.getImageUrl());
        return response;
    }
}
