package com.csis3275.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pay_mavericks")
public class Pay_Mavericks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// https://www.canada.ca/en/revenue-agency/services/tax/businesses/topics/payroll/payroll-deductions-contributions/employment-insurance-ei/ei-premium-rates-maximums.html
	private final double benefitEI = 0.0158; // holds Employment insurance benefit

	// https://www.canada.ca/en/revenue-agency/services/tax/businesses/topics/payroll/payroll-deductions-contributions/canada-pension-plan-cpp/cpp-contribution-rates-maximums-exemptions.html
	private final double benefitCPP = 0.0525; // holds Canada pension plan

	private final double incomeTax = 0.15; // https://www.canada.ca/en/revenue-agency/services/tax/individuals/frequently-asked-questions-individuals/canadian-income-tax-rates-individuals-current-previous-years.html
	private int sickDays;
	private int holidays;
	private Date startDate;
	private Date endDate;
	private int employeeID;
	private boolean payStatus;
	private double totalPaid;

	// Default Constructor
	public Pay_Mavericks() {

	}

	// Constructor
	public Pay_Mavericks(int sickDays, int holidays, Date startDate, Date endDate, int employeeID, boolean payStatus, double totalPaid) {
		this.sickDays = sickDays;
		this.holidays = holidays;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeID = employeeID;
		this.payStatus = payStatus;
		this.totalPaid = totalPaid;
	}


	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBenefitEI() {
		return benefitEI;
	}

	public double getBenefitCPP() {
		return benefitCPP;
	}

	public double getIncomeTax() {
		return incomeTax;
	}

	public int getSickDays() {
		return sickDays;
	}

	public void setSickDays(int sickDays) {
		this.sickDays = sickDays;
	}

	public int getHolidays() {
		return holidays;
	}

	public void setHolidays(int holidays) {
		this.holidays = holidays;
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

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public boolean isPayStatus() {
		return payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

}
