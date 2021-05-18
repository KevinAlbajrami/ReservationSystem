package com.sample.reservationSys.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.reservationSys.entities.User;
import com.sample.reservationSys.repos.UserRepo;
import com.sample.reservationSys.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method= {RequestMethod.POST,RequestMethod.GET})
	public String register(@ModelAttribute("user") User user, @RequestParam("passwordC") String passConf, ModelMap modelMap) {
		if(passConf.equals(user.getPassword())) {
			user.setPassword(encoder.encode(user.getPassword()));
			uRepo.save(user);
			return "login/login";
		}
		else {
			String msg= "Passwords do no match";
			modelMap.addAttribute("msg", msg);
			return "login/registerUser";
		}
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password")String password, ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg", "Invalid UserName or Password");
		}
		return "login/login";
	}
	
	
}
