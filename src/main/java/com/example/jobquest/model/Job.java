package com.example.jobquest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobId")
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
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;
    

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /*
    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "jobId"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Application> applications = new HashSet<>();
    */

    // ===== Constructors =====
    public Job() {
    }

    public Job(String title,String description, String location, int available, int filled, Company company, User postedBy) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.available = available;
        this.filled = filled;
        this.company = company;
        this.postedBy = postedBy;
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

    public User getPostedBy() { 
        return postedBy; 
    }
    public void setPostedBy(User postedBy) { 
        this.postedBy = postedBy; 
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt; 
    }
}
