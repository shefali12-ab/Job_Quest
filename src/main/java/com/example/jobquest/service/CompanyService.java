package com.example.jobquest.service;

import com.example.jobquest.model.*;
import com.example.jobquest.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompanyService implements CompanyRepository{

   @Autowired
   private CompanyJpaRepository jpadb;
   
   @Override
   public List<Company> getCompanies(){
    List<Company> l = new ArrayList<>(jpadb.findAll());
    return l;
   }
   @Override
   public Company getCompanyById(long companyId){
    try{
        Company c = jpadb.findById(companyId).get();
        return c; 
      } catch(Exception e){
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }  
   }
   @Override
   public Company addCompany(Company company){
    return jpadb.save(company);
   }
   @Override
   public Company updateCompany(long companyId, Company company){
    try{
        Company existingCompany = jpadb.findById(companyId).get();
        existingCompany.setName(company.getName());
        existingCompany.setIndustry(company.getIndustry());
        existingCompany.setWebsite(company.getWebsite());
        return jpadb.save(existingCompany);
    } catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
   }
   @Override
   public void deleteCompany(long companyId){
    try{
        jpadb.deleteById(companyId);
    } catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
   }
}
