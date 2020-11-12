package com.csis3275.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model.Pay_Mavericks;

public interface PayrollDao_Mavericks extends JpaRepository<Pay_Mavericks, Integer>{
	Pay_Mavericks findByEmployeeID(int id);
}
