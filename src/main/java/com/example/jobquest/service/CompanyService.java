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

    @Autowired
   private JobJpaRepository jpadb1;
   
   @Override
   public List<Company> getCompanies(){
    List<Company> l = new ArrayList<>(jpadb.findAll());
    return l;
   }
   @Override
   public Company getCompanyById(int companyId){
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
   public Company updateCompany(int companyId, Company company){
    try{
        Company existingCompany = jpadb.findById(companyId).get();
        if(company.getName()!=null) existingCompany.setName(company.getName());
        if(company.getIndustry()!=null) existingCompany.setIndustry(company.getIndustry());
        if(company.getWebsite()!=null) existingCompany.setWebsite(company.getWebsite());
        return jpadb.save(existingCompany);
    } catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
   }
   @Override
   public void deleteCompany(int companyId){
    try{
        jpadb.deleteById(companyId);
    } catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
   }

   @Override
    public Map<Integer, Map<String, Integer>> getJobCountsByCompany() {
        List<Company> companies = jpadb.findAll();
        Map<Integer, Map<String, Integer>> result = new HashMap<>();

        for (Company c : companies) {
            Map<String, Integer> counts = new HashMap<>();
            counts.put("totalJobs", jpadb1.countByCompany(c));
            counts.put("openJobs", jpadb1.countByCompanyAndIsOpenTrue(c));
            result.put(c.getCompanyId(), counts);
        }


        return result;
    }
}
