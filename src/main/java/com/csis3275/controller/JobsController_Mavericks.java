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

@Controller
public class JobsController_Mavericks {
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@RequestMapping("/jobs")
	public String showJobs(ModelMap model) {		
		Jobs_Mavericks job = new Jobs_Mavericks();
		model.addAttribute("job", job);
		
		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
		
		return "jobs_mavericks";
	}
	
	@RequestMapping("/createJob")
	public ModelAndView addJob(@ModelAttribute("job") Jobs_Mavericks job, Model model) {
		ModelAndView mv = new ModelAndView("jobs_mavericks");			
		
		Jobs_Mavericks newJob = new Jobs_Mavericks(job.getTitle(), job.getSalaryPerDay(), 10);
		jobRepo.save(newJob);	
		
		List<Jobs_Mavericks> jobs = jobRepo.findAll();		
		model.addAttribute("jobs", jobs);
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
