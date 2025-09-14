package com.example.jobquest.repository;

import com.example.jobquest.model.Skill;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillJpaRepository extends JpaRepository<Skill, Integer>{
    List<Skill> findBySkillNameIn(List<String> skillNames);
}

