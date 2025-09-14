package com.example.jobquest.model;

import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skills")
public class Skill {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skillid")
    private int skillId;

    @Column(name="skillname", nullable=false , unique=true) 
    private String skillName;

    @ManyToMany(mappedBy = "skills") // inverse side
    @JsonIgnoreProperties("skills")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "skills")
    @JsonIgnoreProperties("skills")
    private Set<Job> jobs = new HashSet<>();

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
 }
    

