package com.team.medico.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@RequestMapping(value="/hello")
public class HomeController {
	

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		
		
		model.addAttribute("serverTime", "yayy" );
		
		return "home";
	}
	
}
