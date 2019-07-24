package com.team.medico.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.User;
import com.team.medico.service.EmailServiceImple;
import com.team.medico.service.MedicoService;

@Controller
public class PatientController {
	
	@Autowired
	private MedicoService userService;
	
	@Autowired
	public EmailServiceImple emailService;
	
	//patient profile
		@RequestMapping(value="/welcome")
		public String welcomePatient(User user,ModelMap model) { //redirecting to patient
			return "patient";
		}
		
		//sign Up for patient
		@RequestMapping(value="/signUpPatient")
		public String signUpPatient(ModelMap model) {
			model.put("user", new User());
			return "sign-up-patient";
		}
		
		//after submit of patient reg form
		@RequestMapping(value="/savePatient")
		public String savePatient(@RequestParam(name = "prefLanguage")List<String> pl, User user, ModelMap model) {
			Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();
			for(String items : pl){
				preferredLanguage.add(userService.getLanguage(items));//fecthing from database
			}
			user.setPreferredLanguage(preferredLanguage);//adding to particular patient
			user.setUserType("patient");
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			userService.insertPatientSignUp(user);
			emailService.sendSimpleMessage(user.getEmailId(), "Welcome To Medico", "Thank you for registering");
			model.put("user", new User());
			return "login";
		}

}
