package com.orebi.ecommerce.service;

import com.orebi.ecommerce.entity.Product;
import com.orebi.ecommerce.model.ProductRequest;
import com.orebi.ecommerce.model.ProductResponse;
import com.orebi.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product = productRepository.save(product);
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    public ProductResponse getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToProductResponse(product);
    }

    public List<ProductResponse> getAllProducts(Specification<Product> spec, Pageable pageable) {
        Page<Product> products = productRepository.findAll(spec, pageable);
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse updateProduct(UUID id, ProductRequest productRequest) {
        ProductResponse existingProduct = getProductById(id);
        BeanUtils.copyProperties(productRequest, existingProduct);
        existingProduct.setUpdatedAt(LocalDateTime.now());
        Product product = new Product();
        BeanUtils.copyProperties(existingProduct,product);
        productRepository.save(product);
        return getProductById(id);
    }

    public void deleteProduct(UUID id) {
        ProductResponse productResponse = getProductById(id);
        Product product = new Product();
        BeanUtils.copyProperties(productResponse,product);
        productRepository.delete(product);
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategoryId(product.getCategory().getId());
        response.setCategoryName(product.getCategory().getName());
        response.setBrand(product.getBrand());
        response.setModelNumber(product.getModelNumber());
        response.setColor(product.getColor());
        response.setWeight(product.getWeight());
        response.setDimensions(product.getDimensions());
        response.setMaterial(product.getMaterial());
        response.setManufacturer(product.getManufacturer());
        response.setOriginCountry(product.getOriginCountry());
        response.setWarranty(product.getWarranty());
        response.setReleaseDate(product.getReleaseDate());
        response.setRating(product.getRating());
        response.setFeatured(product.isFeatured());
        response.setActive(product.isActive());
        response.setImageUrl(product.getImageUrl());
        return response;
    }
}
