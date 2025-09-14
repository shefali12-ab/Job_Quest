package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class JobController{
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable("id") int id){
        return jobService.getJobById(id);
    }

    @PostMapping("/jobs")
    public Job addJob(@RequestBody Job job)
    {
        return jobService.addJob(job);
    }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable("id") int id, @RequestBody Job job)
    {
        
        return jobService.updateJob(id,job);
    }

    @DeleteMapping("/jobs/{id}")
    public void DeleteJobById(@PathVariable("id") int id)
    {
        jobService.DeleteJobById(id);
    }
}