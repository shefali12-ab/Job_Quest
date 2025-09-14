package com.example.jobquest.model;

import jakarta.persistence.*;

@Entity
@Table (name = "company")
public class Company {
    
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "companyid")
	private int companyId;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "industry")
	private String industry;
	
	@Column (name = "website")
	private String website;
	
	public Company () {}
	
	public Company(String name, String industry, String website) {
		this.name = name;
		this.industry = industry;
		this.website = website;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
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

}
