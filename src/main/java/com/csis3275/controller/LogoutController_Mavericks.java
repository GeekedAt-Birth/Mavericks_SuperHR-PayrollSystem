package com.csis3275.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController_Mavericks {

	@RequestMapping("/logout")
	public String logout(ModelMap model,HttpSession session) {
		session.removeAttribute("LOGGED_IN_USER_ID");
		model.addAttribute("message", "Sucessfully Logged out");	
		return "login_mavericks";
	}
}
