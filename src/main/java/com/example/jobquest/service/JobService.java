package com.example.jobquest.service;

import com.example.jobquest.model.*;
import com.example.jobquest.repository.*;
import com.example.jobquest.dto.*;
import java.util.*;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.HttpStatusCode;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JobService implements JobRepository{

   @Autowired
   private JobJpaRepository jpadb;

   @Autowired
   private CompanyJpaRepository jpadb1;

   @Autowired
   private UserJpaRepository jpadb2;

   @Autowired
   private SkillJpaRepository jpadb3;

   
   @Override
   public List<JobResponse> getAllJobs(){
    List<Job> jobs = jpadb.findAll();
    return jobs.stream()
                       .map(job -> new JobResponse(
                        job.getJobId(),
                        job.getTitle(),
                        job.isOpen(),
                        job.getDescription(),
                        job.getLocation(),
                        job.getCompany().getCompanyId(),
                        job.getCompany().getName(),
                        job.getAvailable(),
                        job.getFilled(),
                        job.getCreatedAt(),
                        job.getSkills()
                       )).toList();
   }

   @Override
   public JobResponse getJobById(int id){
     try{
       Job j= jpadb.findById(id).get();
       return new JobResponse(j);

     }catch(Exception e){
         throw new NoSuchElementException("Job with ID " + id + " not found.");
     }
   }

   @Override
   public JobResponse addJob(Job job){
    Company c = jpadb1.findById(job.getCompany().getCompanyId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Company not found!, Please add the company first"));
    job.setCompany(c);
    if (job.getUser().getUserId() != 1){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only Admins can add a job");
    }
    User u = jpadb2.findById(job.getUser().getUserId()).get();
    job.setUser(u);

    if (job.getRequiredSkills() != null && !job.getRequiredSkills().isEmpty()) {
      Set<Skill> skillSet = new HashSet<>();
        for (Integer skillId : job.getRequiredSkills()) {
            Skill s = jpadb3.findById(skillId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found with ID: " + skillId));
            skillSet.add(s);
      }
      job.setSkills(skillSet);
    }
    jpadb.save(job);
    return new JobResponse(job);
   }

   @Override
   public JobResponse updateJob(int id, Job job){
       
       try{
            Job existingJob = jpadb.findById(id).get();
          if(job.getTitle() != null){
            existingJob.setTitle(job.getTitle());
          }
          if(job.getDescription() != null){
            existingJob.setDescription(job.getDescription());
          }
          if(job.getCompany() != null){
            Company c = jpadb1.findById(job.getCompany().getCompanyId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not available!"));
            existingJob.setCompany(c);
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
            User u = jpadb2.findById(job.getUser().getUserId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User is not found!"));
            existingJob.setUser(u);
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
          
        jpadb.save(existingJob);
        return new JobResponse(existingJob);
            
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

   @Override    
   public List<JobSearchFiltersResponse> searchJobs(JobSearchFiltersRequest request) {

        // Normalize empty strings or empty lists to null
        String title = (request.getTitle() == null || request.getTitle().isBlank()) ? null : request.getTitle();
        String location = (request.getLocation() == null || request.getLocation().isBlank()) ? null : request.getLocation();
        List<String> skills = (request.getSkill() == null || request.getSkill().isEmpty()) 
                              ? null 
                              : request.getSkill().stream()
                                       .map(String::toLowerCase)
                                       .toList();

        Sort sort = Sort.by(Sort.Direction.fromString(request.getOrder() == null ? "ASC" : request.getOrder()),
                            request.getSortBy() == null ? "title" : request.getSortBy());

        List<Job> jobs = jpadb.searchJobs(title, location, skills, sort);

        // Map jobs to response DTO
        // Map to response DTO
        return jobs.stream()
                .map(j -> new JobSearchFiltersResponse(
                        j.getJobId(),
                        j.getTitle(),
                        j.getDescription(),
                        j.getLocation(),
                        j.getAvailable(),
                        j.getFilled(),
                        j.isOpen(),
                        j.getSkills().stream().map(s -> s.getSkillName()).collect(Collectors.toSet()),
                        j.getCompany().getCompanyId(),      // Company ID
                        j.getCompany().getName()     // Company Name
                ))
                .toList();
    }

   @Override
   public List<JobResponse> closedJobs(){

        List<Job> closedJobs = jpadb.findByIsOpenFalse();
        if(closedJobs.isEmpty()){
            return null;
        }
        return closedJobs.stream()
                       .map(job -> new JobResponse(
                        job.getJobId(),
                        job.getTitle(),
                        job.isOpen(),
                        job.getDescription(),
                        job.getLocation(),
                        job.getCompany().getCompanyId(),
                        job.getCompany().getName(),
                        job.getAvailable(),
                        job.getFilled(),
                        job.getCreatedAt(),
                        job.getSkills()
                       )).toList();
    }

   @Override
   public List<JobResponse> openJobs(){

        List<Job> openJobs = jpadb.findByIsOpenTrue();
        if(openJobs.isEmpty()){
            return null;
        }
        return openJobs.stream()
                       .map(job -> new JobResponse(
                        job.getJobId(),
                        job.getTitle(),
                        job.isOpen(),
                        job.getDescription(),
                        job.getLocation(),
                        job.getCompany().getCompanyId(),
                        job.getCompany().getName(),
                        job.getAvailable(),
                        job.getFilled(),
                        job.getCreatedAt(),
                        job.getSkills()
                       )).toList();
    }
}