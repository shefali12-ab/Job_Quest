package com.example.jobquest.model;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "users")

public class User{

    public enum Role {
        ADMIN,
        RECRUITER,
        JOB_SEEKER
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @Column(name="username" ,nullable=false ,unique=true)
    private String userName;

    @Column(name="email" , nullable=false ,unique=true)
    private String email;

    @Column(name="password" , nullable=false)
    private String password;

    @Column(name="resumeurl")
    private String resumeUrl;
    
    @Column(name="designation")
    private String designation;
    
    @Column(name="lastlogin" , nullable=true) 
    private LocalDateTime lastLogin; // itially keep it nullable, when user logs in, update it to current time

    @Enumerated(EnumType.STRING)
     @Column(name="role", nullable=false )
    private Role role= Role.JOB_SEEKER; //by default role ?, should keep it to job seeker or null 

    @ManyToMany
    @JoinTable(
        name = "userskill", // join table name
        joinColumns = @JoinColumn(name = "userid"), // FK to User
        inverseJoinColumns = @JoinColumn(name = "skillid") // FK to Skill
    )
    @JsonIgnoreProperties("users") // to prevent infinite recursion during serialization    

    private Set<Skill> skills = new HashSet<>();
    
    public User() {
    }

    public User(String userName, String email, String password, String resumeUrl, String designation, LocalDateTime lastLogin, Role role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.resumeUrl = resumeUrl;
        this.designation = designation;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getResumeUrl() {
        return resumeUrl;
    }
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Skill> getSkills() {
       return skills;
    }
    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

}
