package com.example.jobquest.service;

import com.example.jobquest.model.*;
import com.example.jobquest.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements JobRepository{

   @Autowired
   private JobJpaRepository jpadb;
   
   @Override
   public List<Job> getAllJobs(){
    List<Job> jobs = new ArrayList<>(jpadb.findAll());
    return jobs;
   }

   @Override
   public Job getJobById(int id){
     try{
       Job j= jpadb.findById(id).get();
       return j;

     }catch(Exception e){
         throw new NoSuchElementException("Job with ID " + id + " not found.");
     }
   }

   @Override
   public Job addJob(Job job){
    return jpadb.save(job);
   }

   @Override
   public Job updateJob(int id, Job job){
       
       try{
            Job existingJob = jpadb.findById(id).get();
          if(job.getTitle() != null){
            existingJob.setTitle(job.getTitle());
          }
          if(job.getDescription() != null){
            existingJob.setDescription(job.getDescription());
          }
          if(job.getCompany() != null){
            existingJob.setCompany(job.getCompany());
          }
          if(job.getLocation() != null){
            existingJob.setLocation(job.getLocation());
          }
        
          if(job.getAvailable() != 0){
            //updating available positions only if it's not zero
            existingJob.setAvailable(job.getAvailable());
          }
          if(job.getFilled() != 0){
            //updating filled positions only if it's not zero
            existingJob.setFilled(job.getFilled());
          }
          if(job.getUser() != null){
            existingJob.setUser(job.getUser());
          }
          if(job.getCreatedAt() != null){
            existingJob.setCreatedAt(job.getCreatedAt());
          }
          if(job.getSkills() != null && !job.getSkills().isEmpty()){
            existingJob.setSkills(job.getSkills());
          }
          if(job.getApplications() != null && !job.getApplications().isEmpty()){
            existingJob.setApplications(job.getApplications());
          }
          
          return jpadb.save(existingJob);
            
       }catch(Exception e){
         throw new NoSuchElementException("Job with ID " + id + " not found.");
       }
    }
   

   @Override
   public void DeleteJobById(int id){
    try{
    jpadb.deleteById(id);
   } catch(Exception e){
     throw new NoSuchElementException("Job with ID " + id + " not found.");
   }
}
}
