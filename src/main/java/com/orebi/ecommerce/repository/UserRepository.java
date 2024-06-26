package com.orebi.ecommerce.repository;

import com.orebi.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String>{

    @Query("SELECT u FROM User u WHERE u.user_id = :user_id")
    Optional<User> findByUserId(String user_id);
}
