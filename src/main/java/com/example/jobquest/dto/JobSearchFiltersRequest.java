package com.example.jobquest.dto;

import java.util.*;

public class JobSearchFiltersRequest {

    private String title;
    private String location;
    private List<String> skill;
    private String sortBy;  // Optional
    private String order;

    public JobSearchFiltersRequest(){}

    public JobSearchFiltersRequest(String title, String location, List<String> skill, String sortBy, String order) {
        this.title = title;
        this.location = location;
        this.skill = skill;
        this.sortBy = sortBy;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    
}
