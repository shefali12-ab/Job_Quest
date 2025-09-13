//skill.java
package com.example.jobquest.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// package com.example.jobquest.model;
// import com.example.jobquest.model.job;
import jakarta.persistence.*;
import java.util.*;
 


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
    @JsonIgnoreProperties("skills") // to prevent infinite recursion during serialization
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "skills")
    @JsonIgnoreProperties("skills") // to prevent infinite recursion during serialization
   private Set<Job> jobs = new HashSet<>();

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