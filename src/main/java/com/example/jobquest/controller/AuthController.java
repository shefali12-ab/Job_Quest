package com.example.jobquest.controller;

import com.example.jobquest.model.User;
import com.example.jobquest.repository.UserJpaRepository;
import com.example.jobquest.config.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AuthController {

    @Autowired
    private UserJpaRepository jpadb;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = jpadb.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Generate JWT token with email + role
            return JwtUtil.generateToken(email, user.getRole().name());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
