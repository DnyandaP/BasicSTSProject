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
	private int emailId;
	@Column(name = "degree")
	private String degree;
	@Column(name = "degree_img")
	private String degreeImg;
	@Column(name = "license")
	private String license;
	@Column(name = "license_img")
	private String licenseImg;
	@Column(name = "current_post")
	private double currentPost;
	@Column(name = "pref_language")
	private String prefLanguage;
	@Column(name = "years_of_experience")
	private String yearsOfExperience;
	@Column(name = "practice_hours")
	private String practiceHours;
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
	}

	@OneToOne
	@JoinColumn(name = "email_id")
	private User user;

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
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

	public double getCurrentPost() {
		return currentPost;
	}

	public void setCurrentPost(double currentPost) {
		this.currentPost = currentPost;
	}

	public String getPrefLanguage() {
		return prefLanguage;
	}

	public void setPrefLanguage(String prefLanguage) {
		this.prefLanguage = prefLanguage;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getPracticeHours() {
		return practiceHours;
	}

	public void setPracticeHours(String practiceHours) {
		this.practiceHours = practiceHours;
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
				+ ", licenseImg=" + licenseImg + ", currentPost=" + currentPost + ", prefLanguage=" + prefLanguage
				+ ", yearsOfExperience=" + yearsOfExperience + ", practiceHours=" + practiceHours + ", duration="
				+ duration + ", awards=" + awards + ", specialization=" + specialization + ", specialTraining="
				+ specialTraining + ", rating=" + rating + ", user=" + user + "]";
	}

	
	
}
