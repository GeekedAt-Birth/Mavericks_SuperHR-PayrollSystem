package com.csis3275.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csis3275.dao.PayrollDao_Mavericks;
import com.csis3275.model.Pay_Mavericks;
import com.csis3275.utils.AuthUtils;

@Controller
public class PayController_Mavericks {
	@Autowired
	PayrollDao_Mavericks payRepo;

	@Autowired
	AuthUtils utils;
	
	@RequestMapping("/processPayment")
	public ModelAndView processPayment(@RequestParam int payId,@RequestParam double totalPaid,Model model, ModelAndView mv) {
		if (!utils.isLoggedIn()) {
			mv.setViewName("redirect:/login");
			return mv;
		} else if (!utils.isAdmin()) {
			mv.setViewName("redirect:/employee_profile_mavericks");
			return mv;
		}
		mv.setViewName("redirect:admin_mavericks");
		// 1. Get the pay_maverics row, update payStatus from false to true
		// 2. Create a new row in pay_mavericks with payStatus = False
		
		Optional<Pay_Mavericks> pay = payRepo.findById(payId);
		if(!pay.isEmpty()) {
			pay.get().setPayStatus(true);
			pay.get().setTotalPaid(totalPaid);
			payRepo.save(pay.get());
			
			Date endDate = pay.get().getEndDate();
			Date newStartDate = (addDays(endDate, 1));
			Date newEndDate = (addDays(endDate, 14));
			
			Pay_Mavericks newPay = new Pay_Mavericks();
			newPay.setSickDays(pay.get().getSickDays());
			newPay.setHolidays(pay.get().getHolidays());
			newPay.setStartDate(newStartDate);
			newPay.setEndDate(newEndDate);
			newPay.setEmployeeID(pay.get().getEmployeeID());
			newPay.setPayStatus(false);
			newPay.setTotalPaid(0);
			payRepo.save(newPay);
		}
		
		return mv;
	}

	// Helper method to add days from current date
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
	
}
