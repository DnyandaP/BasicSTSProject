package com.team.medico.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.team.medico.model.AppointmentBooking;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.Timeslot;
import com.team.medico.model.User;
import com.team.medico.service.EmailServiceImple;
import com.team.medico.service.MedicoService;
import com.team.medico.service.SmsService;

@Controller
public class PatientController {
	
	@Autowired
	private MedicoService userService;
	
	@Autowired
	public EmailServiceImple emailService;
	
	@Autowired
	public SmsService sms;
	
	//patient profile
		@RequestMapping(value="/welcome")
		public String welcomePatient(ModelMap model,HttpSession session) { //redirecting to patient
			User user = (User) session.getAttribute("user");
			Set<String> spec =new HashSet<String>();
			if(user!=null) {
				Patient patient = userService.getPatientById(user.getEmailId());
				session.setAttribute("patient", patient);
				
			List<Doctor> docList = userService.getApprovedDoctor();
			for(Doctor d : docList) {
				spec.add(d.getSpecialization());
			}
			session.setAttribute("spec", spec);
			List<AppointmentBooking> appList = userService.getBookedAppointmentForPat(user.getEmailId());
			session.setAttribute("appList", appList);
			}
			return "patient";
		}
		
		@RequestMapping(value="/completeProfile")
		public String completeProfile(ModelMap model, HttpSession session) { //redirecting to patient
			User user = (User) session.getAttribute("user");
			if(user!=null) {
			Patient patient = userService.patientByEmailId(user.getEmailId());
			if(patient!=null) {
				return "profileCompleted";
			}
			model.put("patient", new Patient());
			model.put("history",new History());
			return "complete-profile";
			}
			return "logout";
			}
		
		
		//submit after of Complete Profile
		@RequestMapping(value="/saveCompleteProfile")
		public String saveCompleteProfile(Patient patient, History history, ModelMap model,HttpSession session) {
			User user = (User) session.getAttribute("user");
			if(user!=null) {
				Patient patient1 = userService.getPatientById(user.getEmailId());
				if(patient1==null) {
				
			patient.setUser(user);
			patient.setEmailId(user.getEmailId());
			history.setEmailId(user.getEmailId());
			userService.insertCompletePatient(patient, history);
			model.put("history",new History());
				}
			model.put("patient",patient1);
			return "patient";
			}
			return "logout";
		}
		
		//sign Up for patient(old)
//				@RequestMapping(value="/bookAppointment")
//				public String bookAppointment(ModelMap model, HttpSession session,@RequestParam(name="timeslotId")String slot) {
//					User user = (User) session.getAttribute("user");
//					//int slotId = Integer.parseInt(slot);
//					if(user!=null) {
//					Patient patient = userService.patientByEmailId(user.getEmailId());
//					if(patient!=null) {
//						userService.updateTimeSlotUpdateToBooked(slotId);
//						userService.insertIntoAppointmentBooking(slotId, user.getEmailId());						
//						return "booked";
//					}
//					model.put("patient", new Patient());
//					model.put("history",new History());
//					return "complete-profile";
//					}
//					return "login";
//				}
		
		@RequestMapping(value="/booked")
		public String bookAppointment(ModelMap model, HttpSession session) {
			User user = (User) session.getAttribute("user");
			
			if(user!=null) {
				String slot = (String) session.getAttribute("slot");
				int slotId = Integer.parseInt(slot);
				userService.updateTimeSlotUpdateToBooked(slotId);
				userService.insertIntoAppointmentBooking(slotId, user.getEmailId());
				Timeslot timeslot = userService.getTimeSlotById(slotId);
				emailService.sendSimpleMessage(user.getEmailId(), "Appointment Booked", "Thank you for booking appointment with Medico.\nEnjoy hassel free consultation.");
				emailService.sendSimpleMessage(timeslot.getEmailId(), "Appointment Booked", "Appointment booked by" +user.getUserName()+"\nBooked time slot: "+timeslot.getStartTime()+"-"+timeslot.getEndTime());
				return "booked";
			}
			return "logout";
		}
				//payment
				@RequestMapping(value="/paymentGateway")
				public String payment(ModelMap model, HttpSession session,@RequestParam(name="timeslotId")String slot) {
					User user = (User) session.getAttribute("user");
					if(user!=null) {
					session.setAttribute("slot", slot);
					Patient patient = userService.patientByEmailId(user.getEmailId());
					if(patient!=null) {						
						return "payment";
					}
					model.put("patient", new Patient());
					model.put("history",new History());
					return "complete-profile";
					}
					return "logout";
				}
		
		
		//sign Up for patient
		@RequestMapping(value="/signUpPatient")
		public String signUpPatient(ModelMap model) {
			model.put("user", new User());
			model.put("patient", new Patient());//add now
			return "sign-up-patient";
		}
		
		
		
		
		//after submit of patient reg form
		@RequestMapping(value="/savePatient")
		public String savePatient(@RequestParam(name = "prefLanguage")List<String> pl, User user, ModelMap model) {
			if(userService.getUser(user.getEmailId())!=null) {
				return "sign-up-patient";
			}
			Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();
			for(String items : pl){
				preferredLanguage.add(userService.getLanguage(items));//fecthing from database
			}
			emailService.sendSimpleMessage(user.getEmailId(), "Welcome To Medico", "Thank you for registering.\n\n Have a great health with Medico\n\nYour Email Id: "+user.getEmailId()+"\nPassword: "+user.getPassword());
			user.setPreferredLanguage(preferredLanguage);//adding to particular patient
			user.setUserType("patient");
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			userService.insertPatientSignUp(user);
			sms.sendSMS(user.getContactNo());
			model.put("user", new User());
			return "login";
		}
		//ajax
		@RequestMapping(value="/getDoctorList")
		@ResponseBody
		public String doctorSpecList(ModelMap model,HttpSession session,@RequestParam String spec) throws Exception{ //to get doctor list on spec
			List<Doctor> docList = userService.getApprovedDoctorSpec(spec);
			for(Doctor d: docList) {
				System.out.println(d);
			}
			session.setAttribute("docList", docList);
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		    String arrayToJson = objectMapper.writeValueAsString(docList);
			return arrayToJson;
		}
		@RequestMapping(value="/getTimeList")
		@ResponseBody
		public String doctorTimeSlotList(ModelMap model,HttpSession session,@RequestParam String emailId) throws Exception{ //to get doctor list on spec
			List<Timeslot> timeList = userService.getTimeSlotOfDoctor(emailId);
			
			for(Timeslot d : timeList) {
				System.out.println(d);
			}
			session.setAttribute("timeList", timeList);
			ObjectMapper objectMapper = new ObjectMapper();
		    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		    String arrayToJson = objectMapper.writeValueAsString(timeList);
			return arrayToJson;
		}

}
