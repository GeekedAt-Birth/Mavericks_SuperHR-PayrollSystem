package com.csis3275.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	public String showEmployeeInformation(@RequestParam int userId, Model model) {

		Users_Mavericks updUser = userRepo.findById(userId);
		Jobs_Mavericks job = jobRepo.findById(updUser.getJobId());
		Pay_Mavericks pay = payRepo.findByEmployeeID(userId);

		model.addAttribute("user", updUser);
		model.addAttribute("job", job);
		model.addAttribute("pay", pay);

		return "employee_mavericks";
	}

	/**
	 * This is to format the date format from database and hmtl input
	 * 
	 * @param binder
	 */
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping("/updateEmployeeInfo")
	public ModelAndView updateEmployeeInfo(Users_Mavericks updUser, Pay_Mavericks pay, Model model) {

		ModelAndView admin = new ModelAndView("redirect:/admin_mavericks");

		Pay_Mavericks updPay = payRepo.findByEmployeeID(updUser.getId());
		updPay.setStartDate(pay.getStartDate());
		updPay.setEndDate(pay.getEndDate());
		updPay.setSickDays(pay.getSickDays());
		updPay.setHolidays(pay.getHolidays());

		payRepo.save(updPay);

		model.addAttribute("message", "Updated Employee ID " + updUser.getId());

		return admin;
	}
}
