package com.orebi.ecommerce.controller;

import com.orebi.ecommerce.entity.Product;
import com.orebi.ecommerce.model.ProductResponse;
import com.orebi.ecommerce.service.ProductService;
import com.orebi.ecommerce.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponse> getAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) UUID categoryId,
            Pageable pageable) {

        Specification<Product> spec = Specification.where(
                ProductSpecification.hasName(name)
        ).and(ProductSpecification.hasCategory(categoryId));

        return productService.getAllProducts(spec, pageable);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }
}
