package com.team.medico.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user")
public class User {

	@Column(name = "user_name")
	private String userName;
	//@NotEmpty
	//@Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}", message = "Please provide a valid email address")
	@Id
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "password")
	private String password;
	@Column(name = "gender")
	private String gender;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "aadhar")
	private double aadharNo;
	@Column(name = "dob")
//	@Temporal(TemporalType.DATE)
	private String dob;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "type_of_user")
	private String userType;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "preferred_language_user", joinColumns = {
			@JoinColumn(name = "email_id") }, inverseJoinColumns = { @JoinColumn(name = "language_id") })
	private Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();

	public User() {
		super();
		isActive = true;
// TODO Auto-generated constructor stub
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public Set<PreferredLanguage> getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(Set<PreferredLanguage> preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public double getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(double aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public boolean getIsActive() {
		return isActive;
	}

	/*
	 * public void setIsActive(String isActive) { this.isActive = isActive; }
	 */

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", contactNo=" + contactNo + ", aadharNo=" + aadharNo + ", dob=" + dob + ", isActive=" + isActive
				+ ", userType=" + userType + "]";
	}

}
