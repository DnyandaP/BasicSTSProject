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
	private String emailId;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "weight")
	private String weight;
	@Column(name = "current_medication")
	private String currentMedication;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "occupation")
	private String occupation;
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


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	

	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
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
		return "Patient [emailId=" + emailId + ", bloodGroup=" + bloodGroup + ", weight=" + weight + ", currentMedication="
				+ currentMedication + ", maritalStatus=" + maritalStatus + ", occupation=" + occupation + ", diet="
				+ diet + ", relationshipWithPatient=" + relationshipWithPatient + ", user=" + user + "]";
	}

	
}