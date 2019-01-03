package com.micro.authservice.db;

public class AppUser {
	private Integer userId;
	private String username;
	private String password;
	private String role;

	public AppUser() {
	}
	
	public AppUser(Integer userId, String username, String password, String role) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
