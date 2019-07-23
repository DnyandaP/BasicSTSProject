package com.team.medico.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;

@Controller
public class PatientController {
	
	@Autowired
	private MedicoService userService;
	
	//patient profile
		@RequestMapping(value="/welcome")
		public String welcomePatient(User user,ModelMap model) { //redirecting to patient
			return "patient";
		}
		
		//sign Up for patient
		@RequestMapping(value="/signUpPatient")
		public String signUpPatient(ModelMap model) {
			model.put("user", new User());
			model.put("patient",new Patient());
			model.put("history",new History());
			return "sign-up-patient";
		}
		
		//after submit of patient reg form
		@RequestMapping(value="/savePatient")
		public String savePatient(@RequestParam(name = "prefLanguage")List<String> pl ,History history, Patient patient,User user,ModelMap model) {
			System.out.println(history.getDiseaseType());
			Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();
			for(String items : pl){
				preferredLanguage.add(userService.getLanguage(items));//fecthing from database
			}
			user.setPreferredLanguage(preferredLanguage);//adding to particular patient
			user.setUserType("patient");
			userService.insertPatient(patient, user, history);
			model.put("user", new User());
			model.put("patient",new Patient());
			return "login";
		}

}
