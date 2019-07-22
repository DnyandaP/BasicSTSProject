package com.team.medico.dao;

import com.team.medico.model.User;

public interface MedicoDao {	
	//public void save(final User user);	
	//public void deleteById(int userId);	
	//public void update(User user) ;
	//public List<User> getAll() ;
	public boolean validateUser(final User user);
	public User getUserByEmailId(String emailId);
}

