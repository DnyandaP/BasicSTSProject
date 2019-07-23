package com.team.medico.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team.medico.model.Doctor;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.UploadedFile;
import com.team.medico.model.User;
import com.team.medico.service.MedicoService;

@Controller
public class DoctorController {
	
	@Autowired
	private MedicoService userService;
	
	//doctor profile
		@RequestMapping(value="/welcomeDoctor")
		public String welcomeDoctor(User user,ModelMap model) { //redirecting to doctor
			return "doctor";
		}
		
		
		@RequestMapping(value="/signUpDoctor")
		public String signUpDoctor(ModelMap model) {
			model.put("user", new User());
			model.put("doctor",new Doctor());
			model.put("uploadFile",new UploadedFile());
			return "sign-up-doctor";
		}
		
		//after submit of doctor reg
		@RequestMapping(value="/saveDoctor")
		public String saveDoctor(@RequestParam(name = "prefLanguage")List<String> pl,UploadedFile uploadedFile, Doctor doctor,User user,ModelMap model) {
			
			 InputStream inputStreamL = null;    
			  OutputStream outputStreamL = null;
			  InputStream inputStreamD = null;    
			  OutputStream outputStreamD = null;
			    
			  MultipartFile fileLicense = uploadedFile.getFileLicense();    
			  MultipartFile fileDegree = uploadedFile.getFileDegree();    
			  
			    
			  String fileNameLicense = fileLicense.getOriginalFilename();
			  String fileNameDegree = fileDegree.getOriginalFilename();
			 
			  String pathLicense = "D:\\Medico\\"+user.getContactNo().toString()+"o"+fileNameLicense;
			  String pathDegree = "D:\\Medico\\"+user.getContactNo().toString()+"o"+fileNameDegree;
			  doctor.setDegreeImg(pathDegree);
			  doctor.setLicenseImg(pathLicense);
			
			try {    
				   inputStreamL = fileLicense.getInputStream();
				   inputStreamD = fileDegree.getInputStream();
				    
				   File newFileL = new File(pathLicense);
				   File newFileD = new File(pathDegree);
				   if (!newFileL.exists()) {    
				    newFileL.createNewFile();    
				   }  
				   if (!newFileD.exists()) {    
					    newFileD.createNewFile();    
				   } 
				   outputStreamL = new FileOutputStream(newFileL);    
				   outputStreamD = new FileOutputStream(newFileD);    
				   int read = 0;    
				   byte[] bytes = new byte[1024];    
				    
				   while ((read = inputStreamL.read(bytes)) != -1) {    
				    outputStreamL.write(bytes, 0, read);    
				   } 
				   while ((read = inputStreamD.read(bytes)) != -1) {    
					    outputStreamD.write(bytes, 0, read);    
					   } 
				  } catch (IOException e) {    
				   // TODO Auto-generated catch block    
				   e.printStackTrace();    
				  }    
			
			Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();
			for(String items : pl){
				preferredLanguage.add(userService.getLanguage(items));//fecthing from database
			}
			user.setPreferredLanguage(preferredLanguage);//adding to particular doctor
			user.setUserType("doctor");
			model.put("user", new User());
			model.put("doctor",new Doctor());
			userService.insertDoctor(doctor,user);
			return "login";

		}

//		@RequestMapping(value="/saveDoctor")
//		public String saveDoctor(@RequestParam(name = "prefLanguage")List<String> pl, Doctor doctor,User user,ModelMap model) {
//						
//			
//			Set<PreferredLanguage> preferredLanguage = new HashSet<PreferredLanguage>();
//			for(String items : pl){
//				preferredLanguage.add(userService.getLanguage(items));//fecthing from database
//			}
//			user.setPreferredLanguage(preferredLanguage);//adding to particular doctor
//			user.setUserType("doctor");
//			model.put("user", new User());
//			model.put("doctor",new Doctor());
//			userService.insertDoctor(doctor,user);
//			return "login";
//		}

}
