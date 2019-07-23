package com.team.medico.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="email_id")
	private String emailId;
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "email_id")
	private User user;
	
	public Admin() {
		super();
		status= "Pending";
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Admin [emailId=" + emailId + ", status=" + status + ", user=" + user + "]";
	}
	
}
