package com.team.medico.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timeslot")
public class Timeslot {
	
	@Id
	@GeneratedValue
	@Column(name = "slot_id")
	private int slotId;

	@Column(name = "email_id",insertable = false,updatable = false)
	private String emailId;
	
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	@Column(name = "time_slot_date")
	private Date timeSlotDate;
	@Column(name = "time_slot_status")
	private String timeSlotStatus;
	@ManyToOne
	@JoinColumn(name="email_id")
	private Doctor doctor;
	
	
	
	
	public Timeslot() {
		super();
	}
	public Timeslot(String emailId, String startTime, String endTime, Date timeSlotDate, String timeSlotStatus,
			Doctor doctor) {
		super();
		this.emailId = emailId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timeSlotDate = timeSlotDate;
		this.timeSlotStatus = timeSlotStatus;
		this.doctor = doctor;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Date getTimeSlotDate() {
		return timeSlotDate;
	}
	public void setTimeSlotDate(Date timeSlotDate) {
		this.timeSlotDate = timeSlotDate;
	}
	public String getTimeSlotStatus() {
		return timeSlotStatus;
	}
	public void setTimeSlotStatus(String timeSlotStatus) {
		this.timeSlotStatus = timeSlotStatus;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
