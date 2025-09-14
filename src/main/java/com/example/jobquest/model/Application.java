package com.example.jobquest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "application")
public class Application {

    public enum Status {
		PENDING,
		ACCEPTED,
		REJECTED
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "applicationid")
	private int applicationId;
	
	@ManyToOne
	@JoinColumn (name = "jobid", referencedColumnName = "jobid")
	// @JsonIgnore
	private Job job;
	
	@ManyToOne
	@JoinColumn (name = "userid", referencedColumnName = "userid")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;
	
	@Column (name = "appliedat")
	private LocalDateTime appliedAt;
	
	@PrePersist
	protected void onCreate() {
		appliedAt = LocalDateTime.now();
	}
	
	public Application () {}
	
	public Application( Job job, User user, Status status, LocalDateTime appliedAt) {
		this.job = job;
		this.user = user;
		this.status = status;
		this.appliedAt = appliedAt;
	}
	

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int id) {
		this.applicationId = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

}
