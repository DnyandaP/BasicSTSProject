package com.team.medico.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {
 
@Id
 @Column(name ="disease_id")
 private int diseaseId;
 
 @Column(name = "disease_name")
 private String diseaseName;

 @Column(name = "description")
 private String description;
 
 @ManyToMany(mappedBy = "disease")
 private Set<Symptoms> symptoms = new HashSet<Symptoms>();
 
public int getDiseaseId() {
	return diseaseId;
}

public void setDiseaseId(int diseaseId) {
	this.diseaseId = diseaseId;
}

public String getDiseaseName() {
	return diseaseName;
}

public void setDiseaseName(String diseaseName) {
	this.diseaseName = diseaseName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Set<Symptoms> getSymptoms() {
	return symptoms;
}

public void setSymptoms(Set<Symptoms> symptoms) {
	this.symptoms = symptoms;
}

@Override
public String toString() {
	return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", description=" + description
			+ ", symptoms=" + symptoms + "]";
}


 
 

}
