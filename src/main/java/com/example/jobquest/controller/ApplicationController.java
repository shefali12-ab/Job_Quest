package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.model.*;
import com.example.jobquest.dto.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.*;
// import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService cs;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/applications/jobs/{jobId}/admin") //admin only
    public List<ApplicationResponse> getApplicationsByJobId(@PathVariable ("jobId") int jobId){
        return cs.getApplicationsByJobId(jobId);
    }

    @GetMapping("/applications/users/user") //respective user only
    public List<ApplicationResponse> getApplicationsByUserId(@AuthenticationPrincipal int id){
        return cs.getApplicationsByUserId(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/applications/jobs/{jobId}") //admin only
    public JobResponse getApplicationStats(@PathVariable ("jobId") int jobId){
        return cs.getApplicationStats(jobId);
    }

    // @PostMapping("/applications") //called when user clicks on apply button in jobs
    // public ApplicationResponse applyToAJob(@RequestBody Application a){
    //     return cs.applyToAJob(a);
    // }

    @PostMapping ("/applications/{jobId}/apply")
    public ApplicationResponse applyToAJob(@PathVariable("jobId") int jobId, @AuthenticationPrincipal int id){
        return cs.applyToAJob(jobId, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/applications/{applicationId}/admin") //admin only
    public ApplicationResponse modifyApplicationStatus (@PathVariable ("applicationId") int id, @RequestBody StatusUpdateRequest r){
        // Application.Status m = Application.Status.valueOf(request.getStatus().toUpperCase());
        return cs.modifyApplicationStatus (id,r.getStatus());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/applications/bulk-update/admin") //admin only
    public List<ApplicationResponse> bulkUpdateApplicationStatus (@RequestBody BulkStatusUpdateRequest r){
        return cs.bulkUpdateApplicationStatus(r);
    }

    @DeleteMapping ("/applications/user/{applicationId}") //respective user
    public void deleteUserApplication (@PathVariable("applicationId") int id){
        cs.deleteUserApplication(id);
    }
}
