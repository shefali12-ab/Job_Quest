package com.example.jobquest.dto;
import java.util.*;


public class AddSkillsToUserRequest {

    private List<String> skillNames;

    // Getters and setters
    public List<String> getSkillNames() {
        return skillNames;
    }

    public void setSkillNames(List<String> skillNames) {
        this.skillNames = skillNames;
    }
    
}
