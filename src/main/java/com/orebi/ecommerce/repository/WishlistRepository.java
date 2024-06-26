package com.orebi.ecommerce.repository;

import com.orebi.ecommerce.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {

    List<Wishlist> findByUserId(String userId);

    Wishlist findByUserIdAndProductId(String userId, UUID productId);

    void deleteByUserIdAndProductId(String userId, UUID productId);
}
