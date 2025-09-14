package com.example.jobquest.dto;
import java.util.Set;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.jobquest.model.Skill;
import com.example.jobquest.model.Application;

public class ApplicationResponse {

    private int applicationId;
    private int jobId;
    private String jobTitle;
    private int userId;
    private String userName;
    private String email;
    private Set<Skill> userSkills;
    private Set<Skill> jobSkills;
    private double percentageMatch;
    private Application.Status applicationStatus;



    public ApplicationResponse(int applicationId, int jobId, String jobTitle, int userId, String userName,
            String email, Set<Skill> userSkills, Set<Skill> jobSkills, Application.Status applicationStatus) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.userSkills = userSkills;
        this.jobSkills = jobSkills;
        this.applicationStatus = applicationStatus;
        this.percentageMatch = calculateSkillMatch(userSkills, jobSkills);
    }

    public ApplicationResponse(Application app) {
        this.applicationId = app.getApplicationId();
        this.jobId = app.getJob().getJobId();
        this.jobTitle = app.getJob().getTitle();
        this.userId = app.getUser().getUserId();
        this.userName = app.getUser().getUserName();
        this.email = app.getUser().getEmail();
        this.userSkills = app.getUser().getSkills();
        this.jobSkills = app.getJob().getSkills();
        this.applicationStatus = app.getStatus();
        this.percentageMatch = calculateSkillMatch(userSkills, jobSkills);
    }

    private double calculateSkillMatch(Set<Skill> userSkills, Set<Skill> jobSkills) {
        if (userSkills == null || jobSkills == null || jobSkills.isEmpty()) {
            return 0;
        }

        Set<String> userSkillNames = new HashSet<>();
        for (Skill s : userSkills) {
            userSkillNames.add(s.getSkillName().toLowerCase());
        }

        Set<String> jobSkillNames = new HashSet<>();
        for (Skill s : jobSkills) {
            jobSkillNames.add(s.getSkillName().toLowerCase());
        }

        userSkillNames.retainAll(jobSkillNames);

        return ((double) userSkillNames.size() / jobSkillNames.size()) * 100;
    }

    @JsonProperty("percentageMatch")
    public double ggetPercentageMatch() {
        return percentageMatch;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Skill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(Set<Skill> userSkills) {
        this.userSkills = userSkills;
    }

    public Set<Skill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(Set<Skill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public double getPercentageMatch() {
        return percentageMatch;
    }

    public void setPercentageMatch(double percentageMatch) {
        this.percentageMatch = percentageMatch;
    }

    public Application.Status getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Application.Status applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    
    

    
}

