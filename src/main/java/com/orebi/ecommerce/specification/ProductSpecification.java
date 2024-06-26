package com.orebi.ecommerce.specification;

import com.orebi.ecommerce.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
        return (product, query, builder) ->
                name == null ? builder.conjunction() : builder.like(builder.lower(product.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasCategory(UUID categoryId) {
        return (product, query, builder) ->
                categoryId == null ? builder.conjunction() : builder.equal(product.get("category").get("id"), categoryId);
    }

    // Add more specifications as needed
}
