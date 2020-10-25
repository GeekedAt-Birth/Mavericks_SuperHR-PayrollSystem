package com.csis3275.model;

public class JobPosition_Mavericks {
	public int id;
	public String title;
	public double salaryPerDay;
	public int daysPerPayPeriod;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getSalaryPerDay() {
		return salaryPerDay;
	}
	public void setSalaryPerDay(double salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}
	public int getDaysPerPayPeriod() {
		return daysPerPayPeriod;
	}
	public void setDaysPerPayPeriod(int daysPerPayPeriod) {
		this.daysPerPayPeriod = daysPerPayPeriod;
	}
}
