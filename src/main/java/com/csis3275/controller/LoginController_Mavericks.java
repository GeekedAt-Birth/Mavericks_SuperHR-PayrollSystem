package com.csis3275.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.User_Mavericks;

@Controller
public class LoginController_Mavericks {

	@Autowired
	UserRepository_Mavericks userRepo;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("msg", "Login");
		return "login_mavericks";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("login") User_Mavericks login, User_Mavericks user, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("error", "Please Login");
			return "login_mavericks";
		}
		
		if (userRepo.findById(login.getId()) != null && user.getPassword().equals(login.getPassword())) {
			if (user.isAdmin())
				return "admin_mavericks";
			else
				return "employee_mavericks";
		} else {
			model.addAttribute("error", "Invalid Details - Please Try Again");
			return "login_mavericks";
		}
	}
}
