package com.orebi.ecommerce.controller;

import com.orebi.ecommerce.entity.Product;
import com.orebi.ecommerce.entity.Wishlist;
import com.orebi.ecommerce.model.WishlistRequest;
import com.orebi.ecommerce.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public Wishlist addToWishlist(@RequestBody WishlistRequest wishlistRequest) {
        return wishlistService.addToWishlist(wishlistRequest);
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable String userId) {
        return wishlistService.getWishlistsByUserId(userId);
    }

    @GetMapping("/products/{userId}")
    public List<Product> getProductsInWishlist(@PathVariable String userId) {
        return wishlistService.getProductsInWishlist(userId);
    }

    @PutMapping
    public Wishlist updateWishlist(@RequestBody WishlistRequest wishlistRequest) {
        return wishlistService.updateWishlist(wishlistRequest);
    }

    @DeleteMapping("/{userId}/{productId}")
    public void deleteFromWishlist(@PathVariable String userId, @PathVariable UUID productId) {
        wishlistService.deleteFromWishlist(userId, productId);
    }
}