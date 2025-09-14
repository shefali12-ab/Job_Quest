package com.example.jobquest.repository;

import com.example.jobquest.model.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository <User, Integer>{

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    
}
