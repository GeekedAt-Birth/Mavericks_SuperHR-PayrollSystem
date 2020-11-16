package com.csis3275.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.Users_Mavericks;
import com.csis3275.utils.AuthUtils;

@Controller
public class ManageEmployeeINFOController_Mavericks {
	@Autowired
	UserRepository_Mavericks userRepo;

	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@Autowired
	AuthUtils utils;

	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam int userId, Model model,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		
		userRepo.deleteById(userId);

		List<Users_Mavericks> users = userRepo.findAllEmployees();

		model.addAttribute("users", users);
		model.addAttribute("message", "Deleted Employee: " + userId);
		
		mv.setViewName("redirect:/admin_mavericks");
		
		return mv;
	}

	@RequestMapping("/updateEmployeeInformation")
	public ModelAndView showEmployeeInformation(@RequestParam int userId, Model model,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		
		Users_Mavericks userToUpdate = userRepo.findById(userId);
		model.addAttribute("user", userToUpdate);
		mv.setViewName("updateEmployee_mavericks");
		
		return mv;
	}

	@PostMapping("/updateEmployeeInformation")
	public ModelAndView updateEmployeeInformation(Users_Mavericks userToUpdate,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		
		mv.setViewName("redirect:/admin_mavericks");
		userRepo.save(userToUpdate);

		return mv;
	}

	@ModelAttribute("jobs")
	public List<Jobs_Mavericks> initializeJobs() {
		List<Jobs_Mavericks> jobs = jobRepo.findAll();
		return jobs;
	}

}
