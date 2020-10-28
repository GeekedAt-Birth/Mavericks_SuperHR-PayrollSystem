package com.csis3275.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model.User_Mavericks;

public interface UserRepository_Mavericks extends JpaRepository<User_Mavericks, Integer>{
	
	User_Mavericks findByUsername(String username);
	User_Mavericks findByUsernameAndPassword(String username, String password);
}
