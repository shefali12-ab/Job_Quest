package com.example.jobquest.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// package com.example.JobQuest.Model;

import jakarta.persistence.*;


@Entity
@Table (name = "company")
public class Company {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "companyid")
	private long companyId;
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore  // prevents infinite recursion
    private List<Job> jobs = new ArrayList<>();
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "industry")
	private String industry;
	
	@Column (name = "website")
	private String website;
	
	public Company () {}
	
	public Company(long companyId, String name, String industry, String website) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.industry = industry;
		this.website = website;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}