package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.Company;

public interface CompanyRepository {

    List<Company> getCompanies();
    Company getCompanyById(int companyId);
    Company addCompany(Company company);
    Company updateCompany(int companyId, Company company);
    void deleteCompany(int companyId);
}
