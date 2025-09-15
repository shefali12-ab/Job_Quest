package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService cs;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return cs.getCompanies();
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompanyById(@PathVariable int companyId){
        return cs.getCompanyById(companyId);        
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/companies") //admin only
    public Company addCompany(@RequestBody Company company){
        return cs.addCompany(company);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/companies/{companyId}") //admin only
    public Company updateCompany(@PathVariable int companyId, @RequestBody Company company){
        return cs.updateCompany(companyId, company);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/companies/{companyId}") //admin only
    public void deleteCompany(@PathVariable int companyId){
        cs.deleteCompany(companyId);
    }
    
}
