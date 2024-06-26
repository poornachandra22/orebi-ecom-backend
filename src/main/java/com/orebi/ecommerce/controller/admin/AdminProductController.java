package com.orebi.ecommerce.controller.admin;

import com.orebi.ecommerce.entity.Product;
import com.orebi.ecommerce.model.ProductRequest;
import com.orebi.ecommerce.model.ProductResponse;
import com.orebi.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable UUID id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
