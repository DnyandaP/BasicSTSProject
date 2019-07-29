package com.team.medico.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team.medico.dao.MedicoDao;
import com.team.medico.model.Admin;
import com.team.medico.model.AppointmentBooking;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.Timeslot;
import com.team.medico.model.User;

@Service
public class MedicoServiceImple implements MedicoService {
	
	@Autowired
	private MedicoDao medDao;
	
	@Override
	public boolean checkUser(User user) {
		return medDao.validateUser(user);
	}
	
	@Override
	public User getUser(String emailId) {
		return medDao.getUserByEmailId(emailId);
	}
	
	@Override
	public void insertDoctor(Doctor doctor, User user) {
		medDao.insertDoctor(doctor, user);
	}

	

	@Override
	public void insertPatient(Patient patient, User user,History history) {
		medDao.saveUser(user);
		medDao.savePatient(patient);
		medDao.saveHistory(history);
	}

	@Override
	public PreferredLanguage getLanguage(String languageId) {
		return medDao.getLanguageById(languageId);
		
	}

	@Override
	public void insertAdmin(Admin admin, User user) {
		medDao.saveUser(user);
		medDao.saveAdmin(admin);
		
	}

	@Override
	public void insertPatientSignUp(User user) {
		medDao.saveUser(user);
		
	}

	@Override
	public Doctor doctorByEmailId(String emailId) {
		return medDao.getDoctorByEmailId(emailId);
	}

	@Override
	public boolean aadharExist(double aadhar) {
		return medDao.aadharExist(aadhar);
	}

	@Override
	public boolean contactExist(String contact) {
		return medDao.contactExist(contact);
	}

	@Override
	public void insertCompletePatient(Patient patient, History history) {
		medDao.savePatient(patient);
		medDao.saveHistory(history);
	}

	@Override
	public Patient patientByEmailId(String emailId) {
		return medDao.getPatientByEmailId(emailId);
	}

	@Override
	public List<Doctor> getApprovedDoctor() {
		return medDao.getApprovedDoctor();
	}

	@Override
	public List<Timeslot> getBookedTimeSlotOfDoctor(String emailId) {
		
		return medDao.getBookedTimeSlots(emailId);
	}

	@Override
	public List<AppointmentBooking> getBookedAppointmentOfDoctor(String emailId) {
		return medDao.getBookedAppointment(emailId);
	}

	@Override
	public Timeslot getTimeSlotById(int slotId) {
		return medDao.getTimeSlotById(slotId);
	}

	@Override
	public void insertTokenToAppointment(String token, int slotId) {
		medDao.insertTokenToAppointment(token, slotId);
		
	}

	@Override
	public boolean checkToken(int slotId) {
		
		return medDao.checkToken(slotId);
	}

	@Override
	public String getTokenFromAppointment(int slotId) {
		
		return medDao.getToken(slotId);
	}

	@Override
	public void updateStatus(int slotId) {
		medDao.updateAppointmentBookingStatus(slotId);
		medDao.updateTimeSlotStatus(slotId);
	}

	@Override
	public List<AppointmentBooking> getBookedAppointmentForPat(String emailId) {
		
		return medDao.getBookedAppointmentForPat(emailId);
	}
	@Override
	public List<Doctor> selectAllDoctor() {
		return medDao.getAllDoctor();
	}
	
	@Override
	public Doctor selectDoctor1(String email) {
		return medDao.getDoctor1(email);
	}

	@Override
	public List<Patient> selectAllPatient() {
		return medDao.getAllPatient();
	}

	@Override
	public Doctor approveDoctor(String email) {
		return medDao.approveDoctor(email);
	}

	@Override
	public Doctor delteDoctor(String email) {
		return medDao.deleteDoctor(email);
	}
	@Override
	public List<Doctor> getApprovedDoctorSpec(String spec) {
		return medDao.getApprovedDoctorSpec(spec);
	}

	@Override
	public List<Timeslot> getTimeSlotOfDoctor(String emailId) {
		return medDao.getTimeSlotOfDoctor(emailId);
	}
	

}
