
package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.Job;

public interface JobRepository {
    List<Job> getAllJobs();
    Job getJobById(int id);
    Job addJob(Job job);
    Job updateJob(int id, Job job);
    void DeleteJobById(int id);
    
}
