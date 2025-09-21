package com.example.jobquest.service;

import com.example.jobquest.model.*;
import com.example.jobquest.dto.*;
import com.example.jobquest.repository.*;
import java.util.*;
//import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class ApplicationService implements ApplicationRepository{

   @Autowired
   private ApplicationJpaRepository jpadb;

   @Autowired
   private UserJpaRepository jpadb1;

   @Autowired
   private JobJpaRepository jpadb2;

   @Override
   public List<ApplicationResponse> getApplicationsByJobId(int jobId){     

     return jpadb.findByJobJobId(jobId)
                .stream()
                .map(app -> new ApplicationResponse(
                        app.getApplicationId(),
                        app.getJob().getJobId(),
                        app.getJob().getTitle(),
                        app.getUser().getUserId(),
                        app.getUser().getUserName(),
                        app.getUser().getEmail(),
                        app.getUser().getSkills(),
                        app.getJob().getSkills(),
                        app.getStatus()
                ))
                .toList();
   }
   
   @Override
   public List<ApplicationResponse> getApplicationsByUserId(int id){
      // User u = jpadb1.findById(id).get();
      // List<Application> a = new ArrayList<>(jpadb.findByUserUserId(u));
      // return jpadb.findByUserUserId(id);
    return jpadb.findByUserUserId(id)
            .stream()
            .map(app -> new ApplicationResponse(
                    app.getApplicationId(),
                    app.getJob().getJobId(),
                    app.getJob().getTitle(),
                    app.getUser().getUserId(),
                    app.getUser().getUserName(),
                    app.getUser().getEmail(),
                    app.getUser().getSkills(),
                    app.getJob().getSkills(),
                    app.getStatus()
            ))
            .toList();
   }

   @Override
   public JobResponse getApplicationStats(int jobId){
      Job j = jpadb2.findById(jobId).get();
      int total = jpadb.countByJobJobId(jobId);
      int pending = jpadb.countByJobJobIdAndStatus(jobId, Application.Status.PENDING);
      int accepted = jpadb.countByJobJobIdAndStatus(jobId, Application.Status.ACCEPTED);
      int rejected = jpadb.countByJobJobIdAndStatus(jobId, Application.Status.REJECTED);

      return new JobResponse(j.getJobId(), j.getTitle(),j.getAvailable(), j.getFilled(), total, pending, accepted, rejected);
   }

   @Override
   public ApplicationResponse applyToAJob(int jobId, int id){

      // if (!"JOB_SEEKER".equalsIgnoreCase(user.getRole())) {
      //    throw new NotJobSeekerException("Only job seekers can apply");
      // }
      // int i = a.getJob().getJobId();
      // Job j = jpadb2.findById(i).orElseThrow(() -> new RuntimeException("Job not found"));;
      // if (!j.isOpen()) {
      //   throw new RuntimeException("Job is Closed, No more applications are accepted");
      // }
      // a.setJob(j);
      // int u = a.getUser().getUserId();
      // User m = jpadb1.findById(u).orElseThrow(() -> new RuntimeException("User not found"));
      // a.setUser(m);
      // jpadb.save(a);

      // int applicationsCount = jpadb.countByJobJobId(j.getJobId());
      // if (applicationsCount >= 1.5 * j.getAvailable()) {
      //   j.setOpen(false);
      //   jpadb2.save(j);
      // }

          Job j = jpadb2.findById(jobId)
                   .orElseThrow(() -> new RuntimeException("Job not found"));

    if (!j.isOpen()) {
        throw new RuntimeException("Job is Closed, No more applications are accepted");
    }

    User m = jpadb1.findById(id)
                   .orElseThrow(() -> new RuntimeException("User not found"));

    Application a = new Application();
    a.setJob(j);
    a.setUser(m);
    jpadb.save(a);

    int applicationsCount = jpadb.countByJobJobId(j.getJobId());
    if (applicationsCount >= 1.5 * j.getAvailable()) {
        j.setOpen(false);
        jpadb2.save(j);
    }

      return new ApplicationResponse(a);
   }

   @Override
   public ApplicationResponse modifyApplicationStatus (int id, String s){
      Application a = jpadb.findById(id).get();
      Application.Status m = Application.Status.valueOf(s.toUpperCase());
      a.setStatus(m);
      jpadb.save(a);
      return new ApplicationResponse(a);
   }

   @Transactional
   @Override
   public List<ApplicationResponse> bulkUpdateApplicationStatus (BulkStatusUpdateRequest r){
      List<Application> updatedApps = new ArrayList<>();

      for (BulkStatusUpdateRequest.ApplicationStatusUpdates update : r.getUpdatesList()) {
        Application a = jpadb.findById(update.getApplicationId())
                               .orElseThrow(() -> new RuntimeException("Application not found: " + update.getApplicationId()));
        a.setStatus(update.getStatus());
        updatedApps.add(jpadb.save(a));
      }
      return updatedApps.stream().map(app -> new ApplicationResponse(
                    app.getApplicationId(),
                    app.getJob().getJobId(),
                    app.getJob().getTitle(),
                    app.getUser().getUserId(),
                    app.getUser().getUserName(),
                    app.getUser().getEmail(),
                    app.getUser().getSkills(),
                    app.getJob().getSkills(),
                    app.getStatus()
            ))
            .toList();
   }

   @Override
   public void deleteUserApplication (int id){
      jpadb.deleteById(id);
      throw new ResponseStatusException(HttpStatus.OK, "Successfully deleted");
   }

}


