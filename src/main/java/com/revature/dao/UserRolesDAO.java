package com.revature.dao;

import java.util.List;

import com.revature.models.ERSUser;
import com.revature.models.UserRoles;

public interface UserRolesDAO {
	public List<UserRoles> getAllUserRoles();
	public List<ERSUser> getUsersByRole(UserRoles role);
	
	public boolean addRole(UserRoles roles);
	public boolean updateRole(UserRoles roles);
	public boolean removeRole(int roleId);
}
