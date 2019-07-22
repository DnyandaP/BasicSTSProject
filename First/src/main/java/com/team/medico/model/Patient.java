package com.team.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@Column(name = "email_id")
	private int emailId;
	@Column(name = "blood_group")
	private String degree;
	@Column(name = "weight")
	private String weight;
	@Column(name = "current_medication")
	private String currentMedication;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "occupation")
	private double occupation;
	@Column(name = "diet")
	private String diet;
	@Column(name = "relationship_with_patient ")
	private String relationshipWithPatient ;
	
	
	
	public Patient() {
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


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getCurrentMedication() {
		return currentMedication;
	}


	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public double getOccupation() {
		return occupation;
	}


	public void setOccupation(double occupation) {
		this.occupation = occupation;
	}


	public String getDiet() {
		return diet;
	}


	public void setDiet(String diet) {
		this.diet = diet;
	}


	public String getRelationshipWithPatient() {
		return relationshipWithPatient;
	}


	public void setRelationshipWithPatient(String relationshipWithPatient) {
		this.relationshipWithPatient = relationshipWithPatient;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Patient [emailId=" + emailId + ", degree=" + degree + ", weight=" + weight + ", currentMedication="
				+ currentMedication + ", maritalStatus=" + maritalStatus + ", occupation=" + occupation + ", diet="
				+ diet + ", relationshipWithPatient=" + relationshipWithPatient + ", user=" + user + "]";
	}

	
}