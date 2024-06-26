package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WishlistRequest {

    private String userId;
    private UUID productId;
    private String imageUrl;
}
