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
@Table(name = "symptoms")
public class Symptoms {
 
	@Id
 @Column(name = "symptoms_id")
 private int symptomsId;
 
 @Column(name = "symptoms_name")
 private String symptomsName;
 
 @ManyToMany
 @JoinTable(name = "symptoms_disease",joinColumns = {@JoinColumn(name="symptoms_id")},inverseJoinColumns = {@JoinColumn(name="disease_id")})
 private Set<Disease> disease = new HashSet<Disease>();

 
 
 @Override
 public String toString() {
  return "Symptoms [SymptomsId=" + symptomsId + ", Symptoms=" + symptomsName + "]";
 }



public String getSymptomsName() {
	return symptomsName;
}



public void setSymptomsName(String symptomsName) {
	this.symptomsName = symptomsName;
}



public int getSymptomsId() {
	return symptomsId;
}



public void setSymptomsId(int symptomsId) {
	this.symptomsId = symptomsId;
}



public Set<Disease> getDisease() {
	return disease;
}



public void setDisease(Set<Disease> disease) {
	this.disease = disease;
}
 

}
