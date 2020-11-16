package com.csis3275.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;


@Service
public class AuthUtils {
	@Autowired
	private HttpSession session;
	
	@Autowired
	UserRepository_Mavericks userRepo;
	
	public boolean isLoggedIn() {
		if(session.getAttribute("LOGGED_IN_USER_ID") == null) {
			return false;
		}
		
		return true;
	}

	public boolean isAdmin() {
		if(session.getAttribute("LOGGED_IN_USER_ID") == null) {
			return false;
		}
		else {
			int userId = (int) session.getAttribute("LOGGED_IN_USER_ID");
			Users_Mavericks user = userRepo.findById(userId);
			return user.isAdmin();
		}
	}
}
