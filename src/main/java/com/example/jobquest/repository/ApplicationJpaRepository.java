package com.example.jobquest.repository;

import com.example.jobquest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ApplicationJpaRepository extends JpaRepository <Application, Integer>{
    ArrayList<Application> findByUserUserId(int id);
    ArrayList<Application> findByJobJobId(int id);
    int countByJobJobId(int jobId);
    int countByJobJobIdAndStatus(int jobId, Application.Status status);
}
