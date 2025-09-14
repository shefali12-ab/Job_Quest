package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.dto.JobSearchFiltersResponse;
import com.example.jobquest.dto.JobSearchFiltersRequest;
import com.example.jobquest.dto.JobResponse;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class JobController{
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<JobResponse> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public JobResponse getJobById(@PathVariable("id") int id){
        return jobService.getJobById(id);
    }

    @PostMapping("/jobs") //admin only
    public JobResponse addJob(@RequestBody Job job)
    {
        return jobService.addJob(job);
    }

    @PutMapping("/jobs/{id}") //admin only
    public JobResponse updateJob(@PathVariable("id") int id, @RequestBody Job job)
    { 
        return jobService.updateJob(id,job);
    }

    @DeleteMapping("/jobs/{id}") //admin only
    public void DeleteJobById(@PathVariable("id") int id)
    {
        jobService.DeleteJobById(id);
    }

    @GetMapping("/jobs/search")
    public List<JobSearchFiltersResponse> searchJobsByFilter(@RequestBody JobSearchFiltersRequest request){
        return jobService.searchJobs(request);
    }

    @GetMapping("/jobs/closed")
    public List<JobResponse> closedJobs(){
        return jobService.closedJobs();
    }

    @GetMapping("/jobs/open")
    public List<JobResponse> openJobs(){
        return jobService.openJobs();
    }
    
}
