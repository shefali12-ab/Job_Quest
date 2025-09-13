package com.example.jobquest.repository;

import java.util.*;
import com.example.jobquest.model.Company;

public interface CompanyRepository {

    List<Company> getCompanies();
    Company getCompanyById(long companyId);
    Company addCompany(Company company);
    Company updateCompany(long companyId, Company company);
    void deleteCompany(long companyId);
}
