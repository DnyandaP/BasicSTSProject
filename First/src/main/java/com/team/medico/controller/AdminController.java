package com.team.medico.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.medico.model.Admin;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;

@Controller
public class AdminController {
	
	@Autowired
	private MedicoService medService;
	
	//patient profile
		@RequestMapping(value="/welcomeAdmin")
		public String welcomeAdmin(User user,ModelMap model) { //redirecting to patient
			return "admin";
		}
		
		//sign Up for patient
		@RequestMapping(value="/signUpAdmin")
		public String signUpAdmin(ModelMap model) {
			model.put("user", new User());
			model.put("admin",new Admin());
			return "sign-up-admin";
		}
		
		//after submit of patient reg form
		@RequestMapping(value="/saveAdmin")
		public String saveAdmin(Admin admin,User user,ModelMap model) {
			
			user.setUserType("admin");
			medService.insertAdmin(admin, user);
			model.put("user", new User());
			model.put("admin",new Admin());
			return "login";
		}

}
