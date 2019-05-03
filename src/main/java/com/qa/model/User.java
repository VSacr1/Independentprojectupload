package com.qa.model;
import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

//import org.hibernate.annotations.NaturalId;

@Entity
//@Table(name="user")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userId;
	
	private String username; 
	private String password; 
	private String email; 
	
	public User()
	{
		
	}
	
	public User(String username, String password, String email)
	{
		this.username = username; 
		this.password = password; 
		this.email = email; 
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public String getPassword() {

			return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
