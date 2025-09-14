package com.example.jobquest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.jobquest.repository.*;
import com.example.jobquest.model.*;
import java.util.*;
@Service
public class SkillService implements SkillRepository {
    @Autowired
    private UserJpaRepository userJpaRepo;
    @Autowired
    private SkillJpaRepository jpadb;
    @Autowired
    private JobJpaRepository jobJpaRepo;
    
    @Override
    public List<Skill> getAllSkills(){
        List<Skill> l = new ArrayList<>(jpadb.findAll());
        return l;
    }
    @Override
    public Skill getSkillById(int skillId){
        try{
            Skill s = jpadb.findById(skillId).get();
            return s;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Skill addSkill(Skill skill){
        return jpadb.save(skill);
    } 
    @Override
    public void deleteSkill(int skillId){
        try{
            jpadb.deleteById(skillId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }  
    @Override
    public Set<Skill> addSkillsToUser(int userId, List<String> skillNames) {
        try {
            User user = userJpaRepo.findById(userId).get();
            Set<Skill> userSkills = user.getSkills();

            for (String skillName : skillNames) {
                Skill skill = null;

                // find if already exists
                List<Skill> allSkills = jpadb.findAll();
                for (Skill s : allSkills) {
                    if (s.getSkillName().equalsIgnoreCase(skillName)) {
                        skill = s;
                        break;
                    }
                }

                // if not exist, create new
                if (skill == null) {
                    skill = new Skill(skillName);
                    skill = jpadb.save(skill);
                }

                userSkills.add(skill);
            }

            user.setSkills(userSkills);
            userJpaRepo.save(user);
            return userSkills;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId);
        }
    }
    @Override
    public Set<Skill> getSkillsByUser(int userId) {
        try {
            User user = userJpaRepo.findById(userId).get();
            return user.getSkills();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId);
        }
    }


    @Override
    public Set<Skill> getSkillsByJob(int jobId) {
        try {
            Job job = jobJpaRepo.findById(jobId).get();
            return job.getSkills();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found with id: " + jobId);
        }
        
    }

    @Override
    public Set<Skill> removeAllSkillsFromUser(int userId) {
        try {
            User user = userJpaRepo.findById(userId).get();
            Set<Skill> removedSkills = new HashSet<>(user.getSkills());
            user.getSkills().clear();
            userJpaRepo.save(user);
            return removedSkills;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId);
        }
    }

   
    
}