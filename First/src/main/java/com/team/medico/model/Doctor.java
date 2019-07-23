package com.team.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "degree")
	private String degree;
	@Column(name = "degree_img")
	private String degreeImg;
	@Column(name = "license")
	private String license;
	@Column(name = "license_img")
	private String licenseImg;
	@Column(name = "current_post")
	private String currentPost;
	@Column(name = "years_of_experience")
	private String yearsOfExperience;
	@Column(name = "practice_hours_start")
	private String practiceHoursStart;
	@Column(name = "practice_hours_end")
	private String practiceHoursEnd;
	@Column(name = "duration")
	private double duration;
	@Column(name = "awards")
	private String awards;
	@Column(name = "specialization")
	private String specialization;
	@Column(name = "special_training ")
	private String specialTraining;
	@Column(name="rating")
	private double rating;
	
	public Doctor() {
		super();
		rating = 0;
	}

	@OneToOne
	@JoinColumn(name = "email_id")
	private User user;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegreeImg() {
		return degreeImg;
	}

	public void setDegreeImg(String degreeImg) {
		this.degreeImg = degreeImg;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseImg() {
		return licenseImg;
	}

	public void setLicenseImg(String licenseImg) {
		this.licenseImg = licenseImg;
	}

	public String getCurrentPost() {
		return currentPost;
	}

	public void setCurrentPost(String currentPost) {
		this.currentPost = currentPost;
	}

	

	public String getPracticeHoursStart() {
		return practiceHoursStart;
	}

	public void setPracticeHoursStart(String practiceHoursStart) {
		this.practiceHoursStart = practiceHoursStart;
	}

	public String getPracticeHoursEnd() {
		return practiceHoursEnd;
	}

	public void setPracticeHoursEnd(String practiceHoursEnd) {
		this.practiceHoursEnd = practiceHoursEnd;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSpecialTraining() {
		return specialTraining;
	}

	public void setSpecialTraining(String specialTraining) {
		this.specialTraining = specialTraining;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Doctor [emailId=" + emailId + ", degree=" + degree + ", degreeImg=" + degreeImg + ", license=" + license
				+ ", licenseImg=" + licenseImg + ", currentPost=" + currentPost + ", yearsOfExperience="
				+ yearsOfExperience + ", practiceHoursStart=" + practiceHoursStart + ", practiceHoursEnd="
				+ practiceHoursEnd + ", duration=" + duration + ", awards=" + awards + ", specialization="
				+ specialization + ", specialTraining=" + specialTraining + ", rating=" + rating + ", user=" + user
				+ "]";
	}
	
}
