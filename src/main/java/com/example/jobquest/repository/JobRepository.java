package com.example.jobquest.repository;

import java.util.*;

import com.example.jobquest.dto.JobSearchFiltersRequest;
import com.example.jobquest.dto.JobSearchFiltersResponse;
import com.example.jobquest.dto.JobResponse;
import com.example.jobquest.model.Job;

public interface JobRepository {
    List<JobResponse> getAllJobs();
    JobResponse getJobById(int id);
    JobResponse addJob(Job job);
    JobResponse updateJob(int id, Job job);
    void DeleteJobById(int id);
    List<JobSearchFiltersResponse> searchJobs(JobSearchFiltersRequest request);
    List<JobResponse> closedJobs();
    List<JobResponse> openJobs();

}
