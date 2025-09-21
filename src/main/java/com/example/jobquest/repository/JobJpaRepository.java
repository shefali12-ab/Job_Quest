package com.example.jobquest.repository;

import com.example.jobquest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface JobJpaRepository extends JpaRepository <Job, Integer>{
    @Query("""
        SELECT DISTINCT j FROM Job j 
        LEFT JOIN j.skills s
        WHERE (:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%')))
          AND (:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%')))
          AND (:skills IS NULL OR LOWER(s.skillName) IN :skills)
    """)
    List<Job> searchJobs(@Param("title") String title,
                         @Param("location") String location,
                         @Param("skills") List<String> skill,
                         Sort sort); 
    List<Job> findByIsOpenFalse();
    List<Job> findByIsOpenTrue();

    int countByCompany(Company company);
    int countByCompanyAndIsOpenTrue(Company company);


    // @Query("SELECT COUNT(j) FROM Job j WHERE j.company.companyId = :companyId")
    // int countByCompanyId(@Param("companyId") int companyId);

    // @Query("SELECT COUNT(j) FROM Job j WHERE j.company.companyId = :companyID AND j.isOpen = true")
    // int countOpenByCompanyId(@Param ("companyId") int companyId);
}
