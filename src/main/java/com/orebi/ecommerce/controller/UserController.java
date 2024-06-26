package com.orebi.ecommerce.controller;

import com.orebi.ecommerce.entity.User;
import com.orebi.ecommerce.model.UserProfileDisplayModel;
import com.orebi.ecommerce.model.UserRegistration;
import com.orebi.ecommerce.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public UserProfileDisplayModel registerUser(@RequestBody UserRegistration userRegistration) {
        System.out.println("JaiSriRam");
        System.out.println("Inside Register User");
        User newUser = new User();
        System.out.println("User Object created");
        BeanUtils.copyProperties(userRegistration, newUser);
        System.out.println("Properties copied");
        newUser.setIsActive(true);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(newUser);
        System.out.println("User Stored");

        return convertToUserProfileDisplayModel(savedUser);
    }

    @GetMapping("/verify")
    public UserProfileDisplayModel verifyUser(@RequestParam("user_id") String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return convertToUserProfileDisplayModel(user);
        } else {
            throw new RuntimeException("User not found with userId: " + userId);
        }
    }

    @GetMapping("/profile")
    public UserProfileDisplayModel getUserProfile(@RequestParam("user_id") String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return convertToUserProfileDisplayModel(user);
        } else {
            throw new RuntimeException("User not found with userId: " + userId);
        }
    }

    @PutMapping("/{user_id}")
    public UserProfileDisplayModel updateUser(@PathVariable String user_id, @RequestBody UserRegistration userRegistration) {
        User existingUser = userRepository.findByUserId(user_id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user_id));

        // Update user details
        existingUser.setUsername(userRegistration.getUsername());
        existingUser.setEmail(userRegistration.getEmail());
        existingUser.setFirstName(userRegistration.getFirstName());
        existingUser.setLastName(userRegistration.getLastName());
        existingUser.setAddress(userRegistration.getAddress());
        existingUser.setUpdatedAt(LocalDateTime.now());

        // Save updated user and return the UserProfileDisplayModel
        User updatedUser = userRepository.save(existingUser);
        return convertToUserProfileDisplayModel(updatedUser);
    }

    private UserProfileDisplayModel convertToUserProfileDisplayModel(User user) {
        UserProfileDisplayModel userProfileDisplayModel = new UserProfileDisplayModel();
        BeanUtils.copyProperties(user, userProfileDisplayModel);
        return userProfileDisplayModel;
    }
}
