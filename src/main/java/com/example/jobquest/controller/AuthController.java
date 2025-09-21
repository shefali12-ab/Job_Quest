package com.example.jobquest.controller;

import com.example.jobquest.model.User;
import com.example.jobquest.repository.UserJpaRepository;
import com.example.jobquest.config.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.jobquest.dto.LoginRequest;;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AuthController {

    @Autowired
    private UserJpaRepository jpadb;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest r) {
        User user = jpadb.findByEmail(r.getEmail());
        if (user != null && user.getPassword().equals(r.getPassword())) {
            // Generate JWT token with email + role
            return JwtUtil.generateToken(user.getUserId(),r.getEmail(), user.getRole().name());
        }
        throw new RuntimeException("Invalid credentials");
    }

    @PostMapping("/register")
    public User register(@RequestBody User newUser) {

        if (jpadb.findByEmail(newUser.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }

        User savedUser = jpadb.save(newUser);

        // optionally return token directly:
        // String token = JwtUtil.generateToken(savedUser.getUserId(), savedUser.getEmail(), savedUser.getRole().name());
        // return Map.of("token", token, "user", savedUser);

        return savedUser;
    }
}
