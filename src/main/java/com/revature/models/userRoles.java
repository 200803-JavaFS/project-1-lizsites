package com.revature.models;

import java.io.Serializable;

public class userRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userRoleId;
	private String userRole;
	
	
	public int getUserRoleId() {
		return userRoleId;
	}
	
	
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	
	public String getUserRole() {
		return userRole;
	}
	
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	public userRoles(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}
	
	
	public userRoles() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "userRoles [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
	
	
}
