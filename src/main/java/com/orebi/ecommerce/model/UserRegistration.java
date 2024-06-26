package com.orebi.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistration {
    private String username;
    private String user_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}