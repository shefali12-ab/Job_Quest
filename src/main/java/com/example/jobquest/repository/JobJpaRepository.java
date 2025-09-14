package com.example.jobquest.repository;

import com.example.jobquest.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobJpaRepository extends JpaRepository<Job, Integer>{
    
}