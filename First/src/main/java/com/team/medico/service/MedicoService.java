package com.team.medico.service;



import com.team.medico.model.User;



public interface MedicoService {	
	//public void createUser(User user);
	//public void removeUser(int userId);
	//public void modifyUser(User user);
	//public List<User> selectAllUsers();
	public boolean checkUser(User user);
	public User getUser(String emailId);
}