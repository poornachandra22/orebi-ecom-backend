package com.orebi.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Wishlist")
@Getter
@Setter
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "image_url")
    private String imageUrl;
}