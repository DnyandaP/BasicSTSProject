package com.team.medico.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
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
//		if(session.getAttribute("user")!=null) { //if user comes back to login page without logout
//			session.removeAttribute("user");
//			session.invalidate();
//		}
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
			
				User u1 = userService.getUser(user.getEmailId());//to fetch the data from database about that particular user
				if(u1!=null) {
					session.setAttribute("user", u1);
					return "validate";
				}
			}
		}
		model.put("user", new User());
		model.put("message","Sorry, your password was incorrect. Please double-check your password."); //for incorrect password
		return "login";
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
	
	//ajax call for login page
	@RequestMapping("/getEmail")
	@ResponseBody
	public String getEmail(@RequestParam String emailId) {
		User u1 = userService.getUser(emailId); //we get email id from the ajax call
		if(u1==null) {
			return "Email Address is invaild or not registered";
		}
		return "";
	}
	
	
	//ajax for sign up page
	@RequestMapping("/getEmailAjax")
	@ResponseBody
	public String getEmailAjax(@RequestParam String emailId) {
		User u1 = userService.getUser(emailId); //we get email id from the ajax call
		if(u1!=null) {
			return "Email Address already registered";
		}
		return "";
	}
	
	@RequestMapping("/getContactAjax")
	@ResponseBody
	public String getContactAjax(@RequestParam String contact) {
		if(userService.contactExist(contact)) {
			return "Contact Number already registered";
		}
		return "";
	}
	
	@RequestMapping("/getAadharAjax")
	@ResponseBody
	public String getAadharAjax(@RequestParam double aadhar) {
		if(userService.aadharExist(aadhar)) {
			return "Aadhar Number already registered";
		}
		return "";
	}
	
}
	
	