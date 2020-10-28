package com.csis3275.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User_Mavericks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String email;
	private String password;
	private String confirm_password; // to compare with password if it's matched
	private boolean isAdmin; // for every user it will be false, for the admin we will manually make it true
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User_Mavericks [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirm_password=" + confirm_password + ", isAdmin=" + isAdmin + "]";
	}

}
