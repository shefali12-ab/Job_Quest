package com.example.jobquest.service;

import com.example.jobquest.model.*;
import com.example.jobquest.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CompanyRepository{

   @Autowired
   private CompanyJpaRepository jpadb;
   
   @Override
   public List<Company> getCompanies(){
    List<Company> l = new ArrayList<>(jpadb.findAll());
    return l;
   }
}
