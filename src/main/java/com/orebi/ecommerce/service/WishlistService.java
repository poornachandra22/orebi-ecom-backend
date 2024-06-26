package com.orebi.ecommerce.service;

import com.orebi.ecommerce.entity.Product;
import com.orebi.ecommerce.entity.Wishlist;
import com.orebi.ecommerce.model.ProductResponse;
import com.orebi.ecommerce.model.WishlistRequest;
import com.orebi.ecommerce.repository.WishlistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductService productService; // Assuming ProductService for fetching products

    public Wishlist addToWishlist(WishlistRequest wishlistRequest) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(wishlistRequest.getUserId());

        ProductResponse productResponse = productService.getProductById(wishlistRequest.getProductId());
        Product product = new Product();
        BeanUtils.copyProperties(productResponse,product);
        wishlist.setProduct(product);
        wishlist.setImageUrl(wishlistRequest.getImageUrl());
        wishlist.setCreatedAt(LocalDateTime.now());

        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getWishlistsByUserId(String userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public List<Product> getProductsInWishlist(String userId) {
        List<Wishlist> wishlists = wishlistRepository.findByUserId(userId);
        // Extract products from wishlists
        return wishlists.stream()
                .map(Wishlist::getProduct)
                .toList();
    }

    public Wishlist updateWishlist(WishlistRequest wishlistRequest) {
        Wishlist existingWishlist = wishlistRepository.findByUserIdAndProductId(wishlistRequest.getUserId(), wishlistRequest.getProductId());
        if (existingWishlist != null) {
            existingWishlist.setImageUrl(wishlistRequest.getImageUrl());
            return wishlistRepository.save(existingWishlist);
        }
        // Handle case where wishlist item not found
        return null;
    }

    public void deleteFromWishlist(String userId, UUID productId) {
        wishlistRepository.deleteByUserIdAndProductId(userId, productId);
    }
}
