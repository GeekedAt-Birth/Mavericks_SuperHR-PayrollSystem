package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csis3275.model.User_Mavericks;

@Controller
public class PayrollController_Mavericks {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("msg", "Login");
		return "login.jsp";		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") User_Mavericks login) {
		if (login != null && login.getId() != 0 & login.getPassword() != null) {
			Integer user = login.getId();
			Integer valid = 5;
			if (user.equals(valid) && login.getPassword().equals("")) {
				return "views.jsp";
			} else {
				model.addAttribute("error", "Invalid Details - Please Try Again");
				return "login.jsp";
			}
		} else {
			model.addAttribute("error", "Please Login");
			return "login.jsp";
		}
	}
}
