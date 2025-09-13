package com.example.jobquest.controller;
import org.springframework.web.bind.annotation.*;
import com.example.jobquest.model.*;
import com.example.jobquest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.*;
@RestController
public class SkillController {
    @Autowired
    private SkillService ss;
    
    @GetMapping("/skills")
    public List<Skill> getAllSkills(){
        return ss.getAllSkills();
    }
    @GetMapping("/skills/{skillId}")
    public Skill getSkillById(@PathVariable Long skillId){
        return ss.getSkillById(skillId);
    }
    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill){
        return ss.addSkill(skill);
    }
    @DeleteMapping("/skills/{skillId}")
    public void deleteSkill(@PathVariable Long skillId){
         ss.deleteSkill(skillId);
    }
    @GetMapping("/skills/user/{userId}")
    public Set<Skill> getSkillsByUser(@PathVariable Long userId) {
        return ss.getSkillsByUser(userId);
        
    }
    @PostMapping("/users/{userId}/skills")
    public Set<Skill> addSkillsToUser(@PathVariable Long userId, @RequestBody List<String> skillNames) {
        return ss.addSkillsToUser(userId, skillNames);
    }
    
    @DeleteMapping("/skills/user/{userId}")
    public Set<Skill> removeAllSkillsFromUser(@PathVariable Long userId){
        return ss.removeAllSkillsFromUser(userId);
    }


    
    
}
