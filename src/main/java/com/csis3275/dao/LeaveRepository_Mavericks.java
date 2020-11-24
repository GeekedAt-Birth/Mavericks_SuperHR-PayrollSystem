package com.csis3275.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csis3275.model.LeaveApplications_Mavericks;

public interface LeaveRepository_Mavericks extends JpaRepository<LeaveApplications_Mavericks, Integer> {

	@Query(value="SELECT id, start_date, end_date, days, reason, leave_type, application_status, employee_Id FROM Leave_Applications_Mavericks WHERE application_status = 'pending'", nativeQuery = true)
	List<LeaveApplications_Mavericks> listPendingForms();
	
	@Query(value="SELECT id, start_date, end_date, reason, days, leave_type, application_status, employee_Id FROM Leave_Applications_Mavericks WHERE application_status = 'approved'", nativeQuery = true)
	List<LeaveApplications_Mavericks> listAcceptedForms();
	
	@Query(value="SELECT id, start_date, end_date, reason, days, leave_type, application_status, employee_Id FROM Leave_Applications_Mavericks WHERE application_status = 'rejected'", nativeQuery = true)
	List<LeaveApplications_Mavericks> listRejectedForms();
	
	@Query(value="SELECT COUNT(Application_Status) FROM leave_applications_mavericks WHERE Application_Status = 'pending'", nativeQuery = true)
	int pendingForms();
	
	LeaveApplications_Mavericks findById(int id);
}
