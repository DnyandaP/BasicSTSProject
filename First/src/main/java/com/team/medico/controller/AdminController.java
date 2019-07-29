package com.team.medico.controller;

import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.medico.model.Admin;
import com.team.medico.model.Doctor;
import com.team.medico.model.Patient;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class AdminController {
	
	@Autowired
	private MedicoService medService;
	
	//patient profile
		@RequestMapping(value="/welcomeAdmin")
		public String welcomeAdmin(User user, Doctor doctor, ModelMap model) throws IOException {
			List<Doctor> doctorList = medService.selectAllDoctor();
			List<Patient> patientList = medService.selectAllPatient();

			model.put("doctorList", doctorList);
			model.put("patientList", patientList);

			return "admin";

		}
		@RequestMapping(value = "/view_doctor")
		public String welcomeAdmin1(ModelMap model, @RequestParam String email) throws IOException {
			Doctor doctor = medService.selectDoctor1(email);
			try {
				
				
				//degree image
				File file = new File(doctor.getDegreeImg());
				FileInputStream fis;
				fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int b;
				byte[] buffer = new byte[1024];
				while ((b = fis.read(buffer)) != -1) {
					bos.write(buffer, 0, b);
				}
				byte[] fileBytes = bos.toByteArray();
				fis.close();
				bos.close();
				byte[] encoded = Base64.getEncoder().encode(fileBytes);
				String encodedString = new String(encoded);

				//license image
				File file1 = new File(doctor.getLicenseImg());
				FileInputStream fis1;
				fis1 = new FileInputStream(file1);
				ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
				int b1;
				byte[] buffer1 = new byte[1024];
				while ((b1 = fis1.read(buffer1)) != -1) {
					bos1.write(buffer1, 0, b1);
				}
				byte[] fileBytes1 = bos1.toByteArray();
				fis1.close();
				bos1.close();
				byte[] encoded1 = Base64.getEncoder().encode(fileBytes1);
				String encodedString1 = new String(encoded1);
				
				model.put("degree", encodedString1);
				model.put("license", encodedString);
				model.put("doctorList", doctor);

				return "view-doctor";
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ModelMap map = new ModelMap();
			return null;
		}
		
		
		@RequestMapping(value = "/approve_doctor")
		public String approveDoctor(ModelMap model, @RequestParam String email) throws IOException {
			Doctor doctor = medService.approveDoctor(email);
			welcomeAdmin(null, doctor, model);
			return "admin";	
		}
		
		@RequestMapping(value = "/delete_doctor")
		public String deleteDoctor(ModelMap model, @RequestParam String email) throws IOException {
			Doctor doctor = medService.delteDoctor(email);
			welcomeAdmin(null, doctor, model);
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
