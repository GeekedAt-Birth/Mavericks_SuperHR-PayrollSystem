package com.csis3275.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.UsersRepository_Mavericks;
import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;
import com.csis3275.model.Jobs_Mavericks;

@Controller
public class RegistrationController_Mavericks {
	@Autowired
	UsersRepository_Mavericks userRepo;
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@RequestMapping("/register")
	public String signup(ModelMap model) {
		Users_Mavericks user = new Users_Mavericks();
		model.addAttribute("user", user);
		return "signup_mavericks";
	}
	
	@PostMapping("/register")
	public ModelAndView addUser(Users_Mavericks user,BindingResult result) {
		ModelAndView mv = new ModelAndView("signup_mavericks");
		
		if (result.hasErrors()) {
			return mv;
		}
		
		Users_Mavericks userCheck = userRepo.findByUsername(user.getUsername());
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
	
	@ModelAttribute("jobs")
	public List<Jobs_Mavericks> initializeJobs(){
		List<Jobs_Mavericks> jobs = jobRepo.findAll();
		return jobs;
	}
}
