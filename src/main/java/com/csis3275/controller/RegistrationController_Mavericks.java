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

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;
import com.csis3275.utils.AuthUtils;

import antlr.Utils;

import com.csis3275.model.Jobs_Mavericks;

@Controller
public class RegistrationController_Mavericks {
	@Autowired
	UserRepository_Mavericks userRepo;
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@Autowired
	AuthUtils utils;
	
	@RequestMapping("/register")
	public ModelAndView signup(ModelMap model,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		mv.setViewName("signup_mavericks");
		Users_Mavericks user = new Users_Mavericks();
		model.addAttribute("user", user);
		return mv;		
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
		mv.setViewName("redirect:/admin_mavericks");
		
		return mv;
	}
	
	@ModelAttribute("jobs")
	public List<Jobs_Mavericks> initializeJobs(){
		List<Jobs_Mavericks> jobs = jobRepo.findAll();
		return jobs;
	}
}
