package com.team.medico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.medico.model.Doctor;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;



@Controller

public class MedicoController {
	
	@Autowired
	private MedicoService userService;
	
	@RequestMapping(value = "/hello")
	public String home(ModelMap model) {
		//model.put("user", new User());
		return "home";
	}
	
	
	@RequestMapping(value = "/login_form")
	public String prepLoginForm(ModelMap model) {
		model.put("user", new User());
		model.put("doctor", new Doctor());
		return "login";
	}
	
	
	@RequestMapping(value = "/loginval")
	public String login(User user, Doctor doctor,ModelMap model,HttpSession session) {
		System.out.println(user.getUserName());
		System.out.println(doctor.getLicense());
		boolean b = userService.checkUser(user);
		if(b) {
			session.setAttribute("user", user);
			return "welcome";
		}
		model.put("user", new User());
		return "login";
	}
		
	
}
