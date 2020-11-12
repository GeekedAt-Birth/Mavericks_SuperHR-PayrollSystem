package com.csis3275.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.dao.PayrollDao_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.Pay_Mavericks;
import com.csis3275.model.Users_Mavericks;

@Controller
public class EmployerProfileController_Mavericks {
	
	@Autowired
	UserRepository_Mavericks userRepo;
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@Autowired
	PayrollDao_Mavericks payRepo;
	
	@RequestMapping("/admin_mavericks")
	public String showEmployees(Model model) {
		List<Users_Mavericks> users = userRepo.findAllEmployees();
		
		model.addAttribute("users", users);
		
		return "admin_mavericks";
	}
	
	@RequestMapping("/employee")
	public String showEmployeeInformation(HttpSession session, @RequestParam int userId, Model model) {
		
		Users_Mavericks user = userRepo.findById(userId);
		Jobs_Mavericks job = jobRepo.findById(user.getJobId());
		Pay_Mavericks pay = payRepo.findById(userId);
		
		session.setAttribute("CURRENT_EMPLOYEE", user.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("job", job);
		model.addAttribute("pay", pay);
		
		return "employee_mavericks";
	}
	
	@PostMapping("/updateEmployeeInfo")
	public ModelAndView updateEmployeeInfo(HttpSession session, Pay_Mavericks pay) {
		
		ModelAndView admin = new ModelAndView("redirect:/admin_mavericks");		
		
		int userId = (int) session.getAttribute("CURRENT_EMPLOYEE");
		
		Pay_Mavericks updPay = payRepo.findById(userId);
		updPay.setStartDate(pay.getStartDate());
		updPay.setEndDate(pay.getEndDate());
		updPay.setSickDays(pay.getSickDays());
		updPay.setHolidays(pay.getHolidays());
		
		payRepo.save(updPay);
		
		return admin;
	}

}
