package com.csis3275.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.utils.AuthUtils;

@Controller
public class JobsController_Mavericks {
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@Autowired
	AuthUtils utils;
	
	@RequestMapping("/jobs")
	public ModelAndView showJobs(ModelMap model,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		
		Jobs_Mavericks job = new Jobs_Mavericks();
		model.addAttribute("job", job);
		
		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
		mv.setViewName("jobs_mavericks");
		
		return mv;
	}
	
	@RequestMapping("/createJob")
	public ModelAndView addJob(@ModelAttribute("job") Jobs_Mavericks job, Model model,ModelAndView mv) {
		if(!utils.isLoggedIn()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else if(!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		
		mv.setViewName("jobs_mavericks");			
		
		Jobs_Mavericks newJob = new Jobs_Mavericks(job.getTitle(), job.getSalaryPerDay(), 10);
		jobRepo.save(newJob);	
		
		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
		model.addAttribute("message", "Added Job " + job.getTitle());
		
		return mv;
	}
	
	@RequestMapping("/updateJob")
	public String showUpdateJob(@RequestParam int id, Model model) {		
		Jobs_Mavericks updJob = jobRepo.findById(id);
		model.addAttribute("job", updJob);
		
		return "update_job_mavericks";
	}
	
	@PostMapping("/updateJob")
	public String updateJob(Jobs_Mavericks updJob, Model model) {
		jobRepo.save(updJob);

		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
		
		return "redirect:/jobs";
	}
	
	@RequestMapping("/deleteJob")
	public String deleteJobs(@RequestParam int id, @ModelAttribute("job") Jobs_Mavericks job, Model model) {
			
		jobRepo.deleteById(id);
		
		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
		
		model.addAttribute("message", "Deleted Job: " + id);
		return "jobs_mavericks";
	}
}
