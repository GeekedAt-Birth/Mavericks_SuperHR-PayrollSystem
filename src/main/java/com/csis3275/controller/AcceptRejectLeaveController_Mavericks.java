package com.csis3275.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.LeaveRepository_Mavericks;
import com.csis3275.dao.PayrollDao_Mavericks;
import com.csis3275.model.LeaveApplications_Mavericks;
import com.csis3275.model.Pay_Mavericks;
import com.csis3275.utils.AuthUtils;

@Controller
public class AcceptRejectLeaveController_Mavericks {

	@Autowired
	LeaveRepository_Mavericks leaveRepo;

	@Autowired
	PayrollDao_Mavericks payRepo;

	@Autowired
	AuthUtils utils;

	@RequestMapping("/acceptRejectLeave")
	public ModelAndView showLeaveForms(Model model, ModelAndView mv) {
		if (!utils.isLoggedIn()) {
			mv.setViewName("redirect:/login");
			return mv;
		} else if (!utils.isAdmin()) {
			mv.setViewName("redirect:/accept_reject_leave_mavericks");
			return mv;
		}
		mv.setViewName("accept_reject_leave_mavericks");
		List<LeaveApplications_Mavericks> pending = leaveRepo.listPendingForms();
		List<LeaveApplications_Mavericks> accepted = leaveRepo.listAcceptedForms();
		List<LeaveApplications_Mavericks> rejected = leaveRepo.listRejectedForms();
		model.addAttribute("pending", pending);
		model.addAttribute("accepted", accepted);
		model.addAttribute("rejected", rejected);

		return mv;
	}

	@RequestMapping("/processLeave")
	public String processLeave(@RequestParam int id, Model model, LeaveApplications_Mavericks leave) {
		if (!utils.isLoggedIn())
			return "login_mavericks";
		else if (!utils.isAdmin())
			return "accept_reject_leave_mavericks";

		LeaveApplications_Mavericks updLeave = leaveRepo.findById(id);
		model.addAttribute("leave", updLeave);

		String process = leave.getApplicationStatus();

		if (process.equals("reject")) {
			updLeave.setApplicationStatus("rejected");
			leaveRepo.save(updLeave);
		} else if (process.equals("approve")) {
			updLeave.setApplicationStatus("approved");

			Pay_Mavericks pay = payRepo.findByEmployeeID(id);
			if (updLeave.getLeaveType().equals("sick days")) {
				int sickDays = pay.getSickDays();
				int daysOff = updLeave.getDays();
				pay.setSickDays(sickDays - daysOff);
			} else if (updLeave.getLeaveType().equals("holidays")) {
				int holidays = pay.getHolidays();
				int daysOff = updLeave.getDays();
				pay.setHolidays(holidays - daysOff);
			}
			
			leaveRepo.save(updLeave);
			payRepo.save(pay);
		}

		List<LeaveApplications_Mavericks> pending = leaveRepo.listPendingForms();
		List<LeaveApplications_Mavericks> accepted = leaveRepo.listAcceptedForms();
		List<LeaveApplications_Mavericks> rejected = leaveRepo.listRejectedForms();
		model.addAttribute("pending", pending);
		model.addAttribute("accepted", accepted);
		model.addAttribute("rejected", rejected);

		return "accept_reject_leave_mavericks";
	}
}
