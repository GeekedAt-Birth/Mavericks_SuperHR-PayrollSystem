package com.csis3275.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class JobPosition_Mavericks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String title;
	public double salaryPerDay;
	public int daysPerPayPeriod;
	
	@ManyToMany(mappedBy = "job")
	private Set<User_Mavericks> users;
	
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
	public Set<User_Mavericks> getUsers() {
		return users;
	}
	public void setUsers(Set<User_Mavericks> users) {
		this.users = users;
	}
}
