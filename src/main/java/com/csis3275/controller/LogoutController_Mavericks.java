package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController_Mavericks {

	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		
		model.addAttribute("message", "Sucessfully Logged out");	
		return "login_mavericks";
	}
}
