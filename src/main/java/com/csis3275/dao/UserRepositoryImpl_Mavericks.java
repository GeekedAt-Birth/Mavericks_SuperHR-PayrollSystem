package com.csis3275.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csis3275.model.User_Mavericks;

@Service
public class UserRepositoryImpl_Mavericks {
	@Autowired
	private UserRepository_Mavericks userRepo;
	
	public User_Mavericks findById(int id) {
		return userRepo.findById(id);
	}
}
