package com.team.medico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.medico.service.EmailServiceImple;

@Controller
public class MailController {

	@Autowired
	public EmailServiceImple emailService;

	@RequestMapping(value = "/send")
	public String createMail(Model model) {
		emailService.sendSimpleMessage("dnyanda4@gmail.com", "hekko", "yeahhh");

		return "home";
	}

}
