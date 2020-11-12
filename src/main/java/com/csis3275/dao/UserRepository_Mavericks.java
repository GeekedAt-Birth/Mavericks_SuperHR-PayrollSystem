package com.csis3275.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csis3275.model.Users_Mavericks;

public interface UserRepository_Mavericks extends JpaRepository<Users_Mavericks, Integer>{
	
	Users_Mavericks findByUsername(String username);
	Users_Mavericks findByUsernameAndPassword(String username, String password);
	Users_Mavericks findById(int id);

	@Query(value="SELECT id, confirm_password, password, phone_number, username, is_admin, email, first_name, last_name, job_id FROM Users_Mavericks where is_admin = false", nativeQuery = true)
	List<Users_Mavericks> findAllEmployees();
}
