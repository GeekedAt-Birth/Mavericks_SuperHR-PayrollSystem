package com.csis3275.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csis3275.model.Pay_Mavericks;

public interface PayrollDao_Mavericks extends JpaRepository<Pay_Mavericks, Integer>{
	
	@Query(value="SELECT * FROM PAY_MAVERICKS WHERE EMPLOYEEID=:id AND (START_DATE <= CURDATE() AND END_DATE>= CURDATE())",nativeQuery=true)
	Pay_Mavericks findByEmployeeID(@Param("id")int id);
	
	@Query(value="SELECT * FROM PAY_MAVERICKS WHERE EMPLOYEEID=:id ORDER BY END_DATE DESC LIMIT 1",nativeQuery=true)
	Pay_Mavericks findByEmployeeIDLatest(@Param("id")int id);	
	
//	@Query(value = "SELECT * FROM PAY_MAVERICKS WHERE PAY_STATUS=FALSE", nativeQuery = true)
	@Query(value = "SELECT * FROM PAY_MAVERICKS WHERE ( START_DATE <= CURDATE() AND END_DATE>= CURDATE()) AND PAY_STATUS=FALSE", nativeQuery = true)
	List<Pay_Mavericks> payPendings(); 
	
	@Query(value = "SELECT * FROM PAY_MAVERICKS WHERE EMPLOYEEID=:id AND PAY_STATUS=TRUE", nativeQuery = true)
	List<Pay_Mavericks> lastPayments(@Param("id")int id);
}
