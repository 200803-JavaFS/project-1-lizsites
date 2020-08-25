package com.revature.models;

import java.io.Serializable;

public class ERSUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	
	
	
	public ERSUser(int userId, String username, String password, String firstName, String lastName, String email,
			int role_id) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = role_id;
	}
	
	
	public ERSUser() {
		super();
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole_id() {
		return roleId;
	}
	public void setRole_id(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "ERSUser [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
	
}
