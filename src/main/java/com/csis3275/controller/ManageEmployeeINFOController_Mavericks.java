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

@Controller
public class ManageEmployeeINFOController_Mavericks {
	@Autowired
	UserRepository_Mavericks userRepo;

	@Autowired
	JobsRepository_Mavericks jobRepo;

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int userId, Model model) {
		userRepo.deleteById(userId);

		List<Users_Mavericks> users = userRepo.findAllEmployees();

		model.addAttribute("users", users);
		model.addAttribute("message", "Deleted Employee: " + userId);

		return "redirect:/admin_mavericks";

	}

	@RequestMapping("/updateEmployeeInformation")
	public String showEmployeeInformation(@RequestParam int userId, Model model) {

		Users_Mavericks userToUpdate = userRepo.findById(userId);

		model.addAttribute("user", userToUpdate);

		return "updateEmployee_mavericks";
	}

	@PostMapping("/updateEmployeeInformation")
	public ModelAndView updateEmployeeInformation(Users_Mavericks userToUpdate) {
		ModelAndView mv = new ModelAndView("redirect:/admin_mavericks");

		userRepo.save(userToUpdate);

		return mv;

	}

	@ModelAttribute("jobs")
	public List<Jobs_Mavericks> initializeJobs() {
		List<Jobs_Mavericks> jobs = jobRepo.findAll();
		return jobs;
	}

}
