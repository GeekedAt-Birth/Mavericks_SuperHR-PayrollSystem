package com.csis3275.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.dao.LeaveRepository_Mavericks;
import com.csis3275.dao.PayrollDao_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.LeaveApplications_Mavericks;
import com.csis3275.model.Pay_Mavericks;
import com.csis3275.model.Users_Mavericks;

@Controller
public class EmployeeProfile_Mavericks {

	@Autowired
	UserRepository_Mavericks userRepo;

	@Autowired
	JobsRepository_Mavericks jobRepo;

	@Autowired
	PayrollDao_Mavericks payRepo;

	@Autowired
	LeaveRepository_Mavericks leaveRepo;

	@RequestMapping("/employee_profile_mavericks")
	public ModelAndView showEmployeeProfile(Users_Mavericks user, BindingResult result, HttpSession session) {
		if (session.getAttribute("LOGGED_IN_USER_ID") == null) {
			ModelAndView modelAndView = new ModelAndView("redirect:/login");
			return modelAndView;
		}
		ModelAndView mv = new ModelAndView("employee_profile_mavericks");
		if (result.hasErrors()) {
			return mv;
		}

		int userId = (int) session.getAttribute("LOGGED_IN_USER_ID");
		Users_Mavericks newUser = userRepo.findById(userId);
		Jobs_Mavericks job = jobRepo.findById(newUser.getJobId());
		Pay_Mavericks pay = payRepo.findByEmployeeID(userId);
		List<LeaveApplications_Mavericks> leaveForms = leaveRepo.employeeLeaveForms(userId);
		mv.addObject("user", newUser);
		mv.addObject("job", job);
		mv.addObject("pay", pay);
		mv.addObject("leaveForms", leaveForms);

		return mv;
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

	@PostMapping("/leaveApplication")
	public ModelAndView saveLeave(Users_Mavericks user, @ModelAttribute("leave") LeaveApplications_Mavericks leave, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView("employee_profile_mavericks");
		if (result.hasErrors()) {
			return mv;
		}

		int userId = (int) session.getAttribute("LOGGED_IN_USER_ID");
		LeaveApplications_Mavericks application = new LeaveApplications_Mavericks(leave.getStartDate(), leave.getEndDate(), leave.getReason(), leave.getLeaveType(), "pending", userId);
		leaveRepo.save(application);
		mv.setViewName("redirect:/employee_profile_mavericks");

		return mv;
	}
}
