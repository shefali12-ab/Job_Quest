package com.example.jobquest.controller;

import com.example.jobquest.service.*;
import com.example.jobquest.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService cs;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return cs.getCompanies();
    }
    
}
