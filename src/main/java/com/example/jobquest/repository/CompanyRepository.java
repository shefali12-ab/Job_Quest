package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.Company;
import com.example.jobquest.model.Job;

public interface CompanyRepository {

    List<Company> getCompanies();
    Company getCompanyById(int companyId);
    Company addCompany(Company company);
    Company updateCompany(int companyId, Company company);
    void deleteCompany(int companyId);
    Map<Integer, Map<String, Integer>> getJobCountsByCompany();
    
}
