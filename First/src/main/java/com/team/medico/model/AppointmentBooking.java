package com.team.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_booking")
public class AppointmentBooking {

	@Id
	@Column(name = "slot_id")
	private int slotId;
	
	@Column(name = "email_id",insertable = false,updatable = false)
	private String emailId;
	
	@Column(name = "app_status")
	private String status;
	
	@Column(name = "token")
	private String token;
	
	@OneToOne
	@JoinColumn(name = "email_id")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "slot_id")
	private Timeslot timeslot;
	
	

	public AppointmentBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AppointmentBooking(int slotId, String emailId, String status, Patient patient, Timeslot timeslot) {
		super();
		this.slotId = slotId;
		this.emailId = emailId;
		this.status = status;
		this.patient = patient;
		this.timeslot = timeslot;
	}


	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}
	
	
	
}
