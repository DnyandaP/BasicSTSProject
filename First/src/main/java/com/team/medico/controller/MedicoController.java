package com.team.medico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.medico.model.Doctor;
import com.team.medico.model.Patient;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;



@Controller

public class MedicoController {
	
	@Autowired
	private MedicoService userService;
	
	//symptoms pages i.e. home page
	@RequestMapping(value = "/")
	public String home(ModelMap model) {
		return "home";
	}
	
	//login page
	@RequestMapping(value = "/login_form")
	public String prepLoginForm(ModelMap model,HttpSession session) {
		if(session.getAttribute("user")!=null) { //if user comes back to login page without logout
			session.removeAttribute("user");
			session.invalidate();
		}
		model.put("user", new User());
		model.put("doctor",new Doctor());
		model.put("message",""); //so that the div for wrong password can be empty
		return "login";//changed
	}
	
	
	//validating login page
	@RequestMapping(value = "/login__form")
	public String login(User user,ModelMap model,HttpSession session) {
		if(user.getEmailId()!=null) { //if email id is not entered
			boolean b = userService.checkUser(user);
			if(b) {
				//session.setAttribute("user", user);
				User u1 = userService.getUser(user.getEmailId());//to fetch the data from database about that particular user
				if(u1!=null) {
					session.setAttribute("user", u1);
					System.out.println(u1.getUserType());
					return "validate";
				}
			}
		}
		model.put("user", new User());
		model.put("message","Sorry, your password was incorrect. Please double-check your password."); //for incorrect password
		return "login";
	}

	//patient profile
	@RequestMapping(value="/welcome")
	public String welcomePatient(User user,ModelMap model) { //redirecting to patient
		return "patient";
	}
	
	//doctor profile
	@RequestMapping(value="/welcomeDoctor")
	public String welcomeDoctor(User user,ModelMap model) { //redirecting to doctor
		return "doctor";
	}
	
	//video calling page
	@RequestMapping(value="/video")
	public String helloSuccess(User user,ModelMap model) { //redirecting to doctor
		return "video";
	}
	
	//logout page
	@RequestMapping(value="/logout")
	public String logout(User user,ModelMap model) {
		return "logout";
	}
	
	//ajax call
	@RequestMapping("/getEmail")
	@ResponseBody
	public String getEmail(@RequestParam String emailId) {
		User u1 = userService.getUser(emailId); //we get email id from the ajax call
		if(u1==null) {
			return "Email Address is invaild or not registered";
		}
		return "";
	}
	
	@RequestMapping(value="/signUpDoctor")
	public String signUpDoctor(ModelMap model) {
		model.put("user", new User());
		model.put("doctor",new Doctor());
		return "sign-up-doctor";
	}
	
	@RequestMapping(value="/saveDoctor")
	public String saveDoctor(Doctor doctor,User user,ModelMap model) {
		System.out.println(user.getContactNo());
		System.out.println(doctor.getLicense());
		
		model.put("user", new User());
		model.put("doctor",new Doctor());
		return "login";
	}
	
	//sign Up for patient
	@RequestMapping(value="/signUpPatient")
	public String signUpPatient(ModelMap model) {
		model.put("user", new User());
		model.put("patient",new Patient());
		return "sign-up-patient";
	}
	
	//after submit of patient reg form
	@RequestMapping(value="/savePatient")
	public String savePatient(@RequestParam(name = ""),Patient patient,User user,ModelMap model) {
		System.out.println(user.getContactNo());
		System.out.println(patient.getDiet());
		System.out.println(patient.getBloodGroup());
		user.setUserType("patient");
		userService.insertPatient(patient, user);
		model.put("user", new User());
		model.put("patient",new Patient());
		return "login";
	}
	
	
	
	//testing
	/*@RequestMapping(value = "/login__form")
	public String login(Doctor doctor,User user,ModelMap model,HttpSession session) {
		System.out.println(user.getContactNo());
		System.out.println(doctor.getLicense());
		if(user.getEmailId()!=null) { //if email id is not entered
			System.out.println(user.getEmailId());
			System.out.println(doctor.getLicense());
			boolean b = userService.checkUser(user);
			if(b) {
				//session.setAttribute("user", user);
				User u1 = userService.getUser(user.getEmailId());//to fetch the data from database about that particular user
				if(u1!=null) {
					session.setAttribute("user", u1);
					System.out.println(u1.getUserType());
					return "validate";
				}
			}
		}
		model.put("user", new User());
		model.put("message","Sorry, your password was incorrect. Please double-check your password."); //for incorrect password
		return "login1";//change
	}*/
}
