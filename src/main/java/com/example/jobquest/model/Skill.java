package com.example.jobquest.model;
// import com.example.jobquest.model.job;
import jakarta.persistence.*;
import java.util.Set;
 import java.util.HashSet;


@Entity
@Table(name = "skills")
 public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skillid")
    private Long skillId;

    @Column(name="skillname", nullable=false , unique=true) 
    private String skillName;

    @ManyToMany(mappedBy = "skills") // inverse side
    private Set<User> users = new HashSet<>();

//     @ManyToMany(mappedBy = "skills")
//    private Set<Job> jobs = new HashSet<>();

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
 }