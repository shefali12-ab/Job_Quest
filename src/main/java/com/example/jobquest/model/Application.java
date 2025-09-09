package com.example.jobquest.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "jobid", referencedColumnName = "jobid")
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
	
	public Application(int id, Job job, User user, Status status, LocalDateTime appliedAt) {
		this.id = id;
		this.job = job;
		this.user = user;
		this.status = status;
		this.appliedAt = appliedAt;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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