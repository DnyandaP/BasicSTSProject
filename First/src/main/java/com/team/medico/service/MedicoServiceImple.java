package com.team.medico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.medico.dao.MedicoDao;
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

}
