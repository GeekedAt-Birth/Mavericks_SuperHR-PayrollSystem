package com.csis3275.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;
import com.csis3275.utils.AuthUtils;

@Controller
public class LoginController_Mavericks {

	@Autowired
	UserRepository_Mavericks userRepo;
	
	@Autowired
	private AuthUtils utils;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		ModelAndView mv = new ModelAndView("login_mavericks");
		
		if(!utils.isLoggedIn()) {
			model.addAttribute("msg", "Login");
			return mv;
		}
		else if(utils.isAdmin()) {
			mv = new ModelAndView("redirect:/admin_mavericks");
			return mv;
		}
		else {
			mv = new ModelAndView("redirect:/employee_profile_mavericks");
			return mv;
		}
	}

	@PostMapping("/")
	public ModelAndView submit(Users_Mavericks user, BindingResult result,HttpSession session) {
		ModelAndView login = new ModelAndView("login_mavericks");

		if (result.hasErrors())
			return login;
		
		Users_Mavericks newUser = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()); 
		if ( newUser != null) {
			session.setAttribute("LOGGED_IN_USER_ID",newUser.getId());
			if(utils.isAdmin()) {
				ModelAndView mv =  new ModelAndView("redirect:/admin_mavericks");
				return mv;
			}
			else
			{
				ModelAndView mv =  new ModelAndView("redirect:/employee_profile_mavericks");
				return mv;
			}
		} else {
			login.addObject("error", "Invalid Credentials");
			return login;
		}
	}
}
