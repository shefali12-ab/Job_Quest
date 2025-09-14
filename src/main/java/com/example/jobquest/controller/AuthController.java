// package com.example.jobquest.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// import com.example.jobquest.model.User;
// import com.example.jobquest.repository.UserJpaRepository;
// import com.example.jobquest.dto.LoginRequest;
// import com.example.jobquest.dto.JwtResponse;
// import com.example.jobquest.config.JwtUtil;

// // import java.util.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//   @Autowired
//     private UserJpaRepository userRepository;

//     @Autowired
//     private JwtUtil jwtUtil; // Your JWT helper class

//     @PostMapping("/register")
//     public ResponseEntity<?> registerUser(@RequestBody User user) {
//         if (userRepository.existsByEmail(user.getEmail())) {
//             return ResponseEntity.badRequest().body("Email already in use");
//         }
//         userRepository.save(user);
//         return ResponseEntity.ok("User registered successfully");
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//         User user = userRepository.findByEmail(request.getEmail())
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         // Plain-text password check
//         if (!request.getPassword().equals(user.getPassword())) {
//             return ResponseEntity.badRequest().body("Invalid credentials");
//         }

//         String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
//         return ResponseEntity.ok(new JwtResponse(token, user.getUserId(), user.getRole().name()));
//     }

//     @GetMapping("/me")
//     public ResponseEntity<?> getCurrentUser(Authentication authentication) {
//         String email = authentication.getName();
//         User user = userRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//         return ResponseEntity.ok(user);
//     }

// }
