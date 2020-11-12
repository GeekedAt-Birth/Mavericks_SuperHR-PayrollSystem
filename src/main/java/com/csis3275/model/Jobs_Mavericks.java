package com.csis3275.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs_mavericks")
public class Jobs_Mavericks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String title;
	public double salaryPerDay;
	public int payPeriod;
	
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
	public int getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(int payPeriod) {
		this.payPeriod = payPeriod;
	}
	
	@Override
	public String toString() {
		return "Jobs_Mavericks [id=" + id + ", title=" + title + ", salaryPerDay=" + salaryPerDay + ", payPeriod="
				+ payPeriod + "]";
	}
	
	public Jobs_Mavericks() {
		//default constructor
	}
	
	public Jobs_Mavericks(String title, double salaryPerDay, int payPeriod) {
		this.title = title;
		this.salaryPerDay = salaryPerDay;
		this.payPeriod = payPeriod;
	}
	
}
