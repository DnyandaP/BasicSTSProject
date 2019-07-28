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

	

}
