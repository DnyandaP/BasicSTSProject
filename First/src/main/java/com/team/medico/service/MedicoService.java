package com.team.medico.service;



import java.util.List;

import com.team.medico.model.Admin;
import com.team.medico.model.AppointmentBooking;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.Timeslot;
import com.team.medico.model.User;



public interface MedicoService {
	// public void createUser(User user);
	// public void removeUser(int userId);
	// public void modifyUser(User user);
	// public List<User> selectAllUsers();
	public boolean checkUser(User user);
	public void insertTokenToAppointment(String token,int slotId);
	public boolean checkToken(int slotId);
	public String getTokenFromAppointment(int slotId);
	public void updateStatus(int slotId);
	public List<Doctor> getApprovedDoctor();
	public List<AppointmentBooking> getBookedAppointmentForPat(String emailId);

	public User getUser(String emailId);

	public void insertPatient(Patient patient, User user, History history);
	
	public void insertPatientSignUp(User user );
	
	public boolean aadharExist(double aadhar);
	public boolean contactExist(String contact);
	

	public PreferredLanguage getLanguage(String languageId);

	public void insertDoctor(Doctor doctor, User user);

	public void insertAdmin(Admin admin, User user);
	
	public Doctor doctorByEmailId(String emailId);
	
	public Patient patientByEmailId(String emailId);
	
	public void insertCompletePatient(Patient patient, History history);
	
	public List<Timeslot> getBookedTimeSlotOfDoctor(String emailId);
	
	public List<AppointmentBooking> getBookedAppointmentOfDoctor(String emailId);
	
	public Timeslot getTimeSlotById(int slotId);
	public List<Doctor> selectAllDoctor();
	public List<Patient> selectAllPatient();
	public Doctor selectDoctor1(String email);

	public Doctor approveDoctor(String email);

	public Doctor delteDoctor(String email);
	public List<Doctor> getApprovedDoctorSpec(String spec);
	public List<Timeslot> getTimeSlotOfDoctor(String emailId);
}