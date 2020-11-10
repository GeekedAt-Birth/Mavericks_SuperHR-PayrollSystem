package com.csis3275.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.Users_Mavericks;

@Controller
public class EmployeeProfile_Mavericks {
	
	@Autowired
	UserRepository_Mavericks userRepo;
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@RequestMapping("/employee_profile_mavericks")
	public ModelAndView showEmployeeProfile(Users_Mavericks user,BindingResult result,HttpSession session) {
		if(session.getAttribute("LOGGED_IN_USER_ID") == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/login");
			return modelAndView;
		}
		ModelAndView mv = new ModelAndView("employee_profile_mavericks");		
		if (result.hasErrors()) {
			return mv;
		}
		int userId = (int) session.getAttribute("LOGGED_IN_USER_ID");
		Users_Mavericks newUser = userRepo.findById(userId);
		Jobs_Mavericks job = jobRepo.findById(userId);
		mv.addObject("user", newUser);
		mv.addObject("job",job);
		
		return mv;
	}
	
	@PostMapping("/updateEmployeeProfile")
	public ModelAndView updateProfile(Users_Mavericks user,BindingResult result,HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/employee_profile_mavericks");

		int userId = (int) session.getAttribute("LOGGED_IN_USER_ID");
		Users_Mavericks newUser = userRepo.findById(userId);
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPhoneNumber(user.getPhoneNumber());
		
		userRepo.save(newUser);
		
		return mv;
	}
}
