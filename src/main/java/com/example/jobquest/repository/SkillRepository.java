package com.example.jobquest.repository;
import java.util.*;
import com.example.jobquest.model.Skill;

public interface SkillRepository {
    List<Skill> getAllSkills();
    Skill getSkillById(Long skillId);
    Skill addSkill(Skill skill);
    // Skill updateSkill(Long skillId, Skill skill);
    void deleteSkill(Long skillId);
    Set<Skill> addSkillsToUser(Long userId, List<String> skillNames);
    Set<Skill> getSkillsByUser(Long userId);
    Set<Skill> removeAllSkillsFromUser(Long userId);

    
}
