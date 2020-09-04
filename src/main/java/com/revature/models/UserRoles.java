package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ers_user_roles", schema="public")
public class UserRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ers_user_role_id")
	private int userRoleId;
	
	@Column(name="user_role")
	private String roleName;
	
	
//	private List<ERSUser> users;
	
	
	public UserRoles() {
		super();
	}

	public UserRoles(int userRoleId, String roleName) {
		super();
		this.userRoleId = userRoleId;
		this.roleName = roleName;
		//this.users = users;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public List<ERSUser> getUsers() {
//		return users;
//	}

//	public void setUsers(List<ERSUser> users) {
//		this.users = users;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + userRoleId;
		//result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
//		if (users == null) {
//			if (other.users != null)
//				return false;
//		} else if (!users.equals(other.users))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "userRoles [userRoleId=" + userRoleId + ", roleName=" + roleName + "]";
	}

	
	
	
	
	
}
