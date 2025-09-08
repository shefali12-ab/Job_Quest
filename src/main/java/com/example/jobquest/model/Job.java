package com.example.jobquest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobid")
    private Long jobId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "available")
    private int available;

    @Column(name = "filled")
    private int filled;

    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    

    @Column(name = "createdat")
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "jobid"),
            inverseJoinColumns = @JoinColumn(name = "skillid")
    )
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Application> applications = new HashSet<>();


    // ===== Constructors =====
    public Job() {
    }

    public Job(String title,String description, String location, int available, int filled, Company company, User user) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.available = available;
        this.filled = filled;
        this.company = company;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getters and Setters =====

    public Long getJobId() { 
        return jobId; 
    }
    public void setJobId(Long jobId) { 
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

    public Company getCompany() { 
        return company; 
    }
    public void setCompany(Company company) { 
        this.company = company; 
    }

    public User getUser() { 
        return user; 
    }
    public void setUser(User user) { 
        this.user = user; 
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt; 
    }
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
}
