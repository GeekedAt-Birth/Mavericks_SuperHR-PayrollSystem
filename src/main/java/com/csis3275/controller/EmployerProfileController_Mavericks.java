package com.csis3275.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.Users_Mavericks;

@Controller
public class EmployerProfileController_Mavericks {
	
	@Autowired
	UserRepository_Mavericks userRepo;
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@RequestMapping("/admin_mavericks")
	public String showEmployees(Model model) {
		List<Users_Mavericks> users = userRepo.findAll();
		
		model.addAttribute("users", users);
		
		return "admin_mavericks";
	}
	
	@RequestMapping("/employee")
	public String showEmployeeInformation(@RequestParam int userId, Model model) {
		
		Users_Mavericks user = userRepo.findById(userId);
		Jobs_Mavericks job = jobRepo.findById(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("job", job);
		
		return "employee_mavericks";
	}
}
