package com.orebi.ecommerce.entity;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
@Getter
@Setter
public class User {
    @Id
    private String user_id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String imageUrl;
    private Boolean isAdmin;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
