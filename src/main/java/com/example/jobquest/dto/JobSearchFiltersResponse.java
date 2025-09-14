package com.example.jobquest.dto;
import java.util.Set;

public class JobSearchFiltersResponse {
    
    private int jobId;
    private String title;
    private String description;
    private String location;
    private int available;
    private int filled;
    private Set<String> skillNames;
    private int companyId;
    private String companyName;
    private boolean isOpen;

    public JobSearchFiltersResponse(){}
    
    public JobSearchFiltersResponse(int jobId, String title, String description, String location, int available,
            int filled, boolean isOpen, Set<String> skillNames, int companyId, String companyName) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.available = available;
        this.filled = filled;
        this.skillNames = skillNames;
        this.companyId = companyId;
        this.companyName = companyName;
        this.isOpen = isOpen;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public int getAvailable() {
        return available;
    }
    public void setAvailable(int available) {
        this.available = available;
    }
    public int getFilled() {
        return filled;
    }
    public void setFilled(int filled) {
        this.filled = filled;
    }

    public Set<String> getSkillNames() {
        return skillNames;
    }

    public void setSkillNames(Set<String> skillNames) {
        this.skillNames = skillNames;
    }
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

}
