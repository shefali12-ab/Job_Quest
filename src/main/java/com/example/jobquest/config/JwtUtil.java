package com.example.jobquest.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "my4secretsecretsecretsecretkeyisveryverylonganditis123"; // min 256 bits
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public static String generateToken(int userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)            // Store username in token
                .claim("userId", userId)
                .claim("role", role)             // Store role in token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static int extractUserId(String token) {
        return extractClaims(token).get("userId", Integer.class);
    }

    public static String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public static boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

