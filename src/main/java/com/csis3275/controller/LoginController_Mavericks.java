package com.csis3275.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;

@Controller
public class LoginController_Mavericks {

	@Autowired
	UserRepository_Mavericks userRepo;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("msg", "Login");
		return "login_mavericks";
	}

	@PostMapping("/login")
	public ModelAndView submit(Users_Mavericks user, BindingResult result) {
		ModelAndView login = new ModelAndView("login_mavericks");

		if (result.hasErrors())
			return login;
		
		if (userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			if (userRepo.findByUsername(user.getUsername()).isAdmin())
				login.setViewName("admin_mavericks");
			else
				login.setViewName("employee_mavericks");
		} else {
			login.addObject("error", "Invalid Credentials");
			return login;
		}
		
		return login;
	}
}
