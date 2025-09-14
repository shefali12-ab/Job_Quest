package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.Skill;

public interface SkillRepository {
    List<Skill> getAllSkills();
    Skill getSkillById(int skillId);
    Skill addSkill(Skill skill);
    // Skill updateSkill(int skillId, Skill skill);
    void deleteSkill(int skillId);
    Set<Skill> addSkillsToUser(int userId, List<String> skillNames);
    Set<Skill> getSkillsByUser(int userId);
    Set<Skill> getSkillsByJob(int jobId);
    Set<Skill> removeAllSkillsFromUser(int userId);    
}

