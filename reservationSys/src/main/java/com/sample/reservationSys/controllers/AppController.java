package com.sample.reservationSys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.reservationSys.util.EmailUtil;

@Controller
public class AppController {
	
	@Autowired
	EmailUtil util;
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String contact() {
		
		return "contactForm";
	}
	
	@RequestMapping(value="/sendEmail")
	public String sendEmail(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("message") String message, ModelMap modelMap) {
		util.sendEmail(email, "Support for "+name, message);
		modelMap.addAttribute("msg", "Email Sent successfully");
		return "contactForm";
	}
	
}
