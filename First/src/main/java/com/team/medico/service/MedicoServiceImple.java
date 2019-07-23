package com.team.medico.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.team.medico.dao.MedicoDao;
import com.team.medico.model.Admin;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
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
		System.out.println(user.getContactNo());
		System.out.println(doctor.getLicense());
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

	

}
