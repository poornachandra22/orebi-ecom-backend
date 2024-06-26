package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDisplayModel {
    private String user_id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}