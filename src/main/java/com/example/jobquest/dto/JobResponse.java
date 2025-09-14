package com.example.jobquest.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.jobquest.model.Job;
import com.example.jobquest.model.Skill;
import com.fasterxml.jackson.annotation.JsonInclude;
// import com.fasterxml.jackson.annotation.JsonPropertyOrder;
// import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({
        "jobId", "jobTitle", "positionsAvailable", "positionsFilled", "skills", "applicationsReceived", "pending", 
        "accepted", "rejected", "companyId", "companyName", "isOpen", "createdAt", "description", "location"
    })
public class JobResponse {

    private int jobId;
    private String jobTitle;
    private int positionsAvailable;
    private int positionsFilled;
    private int applicationsReceived;
    private int pending;
    private int accepted;
    private int rejected;

    private int companyId;
    private String companyName;
    private boolean isOpen;
    private LocalDateTime createdAt;
    private String description;
    private String location;
    private Set<Skill> skills;


    public JobResponse() {}

    
    public JobResponse(int jobId, String jobTitle, int positionsAvailable, int positionsFilled,
                                  int applicationsReceived, int pending, int accepted, int rejected) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.positionsAvailable = positionsAvailable;
        this.positionsFilled = positionsFilled;
        this.applicationsReceived = applicationsReceived;
        this.pending = pending;
        this.accepted = accepted;
        this.rejected = rejected;
    }

 
    public JobResponse(int jobId, String jobTitle, boolean isOpen, String description, String location, int companyId, String companyName, int positionsAvailable, int positionsFilled,
                                LocalDateTime createdAt) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.isOpen = isOpen;
        this.description = description;
        this.location = location;
        this.companyId = companyId;
        this.companyName = companyName;
        this.positionsAvailable = positionsAvailable;
        this.positionsFilled = positionsFilled;
        this.createdAt = createdAt;
    }


    public JobResponse(Job job) {
        this.jobId = job.getJobId();
        this.jobTitle = job.getTitle();
        this.isOpen = job.isOpen();
        this.description = job.getDescription();
        this.skills = job.getSkills();
        this.location = job.getLocation();
        this.companyId = job.getCompany().getCompanyId();
        this.companyName = job.getCompany().getName();
        this.positionsAvailable = job.getAvailable();
        this.positionsFilled = job.getFilled();
        this.createdAt = job.getCreatedAt();
    }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public int getPositionsAvailable() { return positionsAvailable; }
    public void setPositionsAvailable(int positionsAvailable) { this.positionsAvailable = positionsAvailable; }

    public int getPositionsFilled() { return positionsFilled; }
    public void setPositionsFilled(int positionsFilled) { this.positionsFilled = positionsFilled; }

    public int getApplicationsReceived() { return applicationsReceived; }
    public void setApplicationsReceived(int applicationsReceived) { this.applicationsReceived = applicationsReceived; }

    public int getPending() { return pending; }
    public void setPending(int pending) { this.pending = pending; }

    public int getAccepted() { return accepted; }
    public void setAccepted(int accepted) { this.accepted = accepted; }

    public int getRejected() { return rejected; }
    public void setRejected(int rejected) { this.rejected = rejected; }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Set<Skill> getSkills() {
        return skills;
    }


    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    
}

