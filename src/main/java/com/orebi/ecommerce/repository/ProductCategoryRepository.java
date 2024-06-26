package com.orebi.ecommerce.repository;

import com.orebi.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
}
