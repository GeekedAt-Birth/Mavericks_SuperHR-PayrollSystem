package com.csis3275.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LeaveApplications_Mavericks")
public class LeaveApplications_Mavericks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date startDate;
	private Date endDate;
	private int days;
	private String reason;
	private String leaveType;
	private String applicationStatus;
	private int employeeId;
	
	//Default Constructor
	public LeaveApplications_Mavericks() {
		
	}
	//Constructor
	public LeaveApplications_Mavericks(Date startDate, Date endDate, int days, String reason, String leaveType, String applicationStatus, int employeeId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
		this.reason = reason;
		this.leaveType = leaveType;
		this.applicationStatus = applicationStatus;
		this.employeeId = employeeId;		
		
	}
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	

}
