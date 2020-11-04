package com.csis3275.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model.Users_Mavericks;

public interface UsersRepository_Mavericks extends JpaRepository<Users_Mavericks, Integer>{
	
	Users_Mavericks findByUsername(String username);
	Users_Mavericks findByUsernameAndPassword(String username, String password);
}
