package com.csis3275.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.User_Mavericks;

@Controller
public class RegistrationController_Mavericks {
	@Autowired
	UserRepository_Mavericks userRepo;
	
	@RequestMapping("/register")
	public String signup(ModelMap model) {
		User_Mavericks user = new User_Mavericks();
		model.addAttribute("user", user);
		return "signup_mavericks";
	}
	
	@PostMapping("/register")
	public ModelAndView addUser(User_Mavericks user,BindingResult result) {
		ModelAndView mv = new ModelAndView("signup_mavericks");
		
		if (result.hasErrors()) {
			return mv;
		}
		
		User_Mavericks userCheck = userRepo.findByUsername(user.getUsername());
		if (userCheck != null) {
			mv.addObject("error", "Username already exists");
			return mv;
		}
		if(!user.getPassword().equals(user.getConfirm_password())) {
			mv.addObject("error", "Password did not match");
			return mv;
		}

		userRepo.save(user);
		mv.addObject("message", "We have created your account successfully.");
		mv.setViewName("success_mavericks");
		
		return mv;
	}
}
