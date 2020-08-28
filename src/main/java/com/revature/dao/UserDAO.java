package com.revature.dao;

import java.util.List;
import java.util.Set;

import com.revature.models.ERSUser;

public interface UserDAO {
	public ERSUser getUserByUsername(String username);
	public ERSUser getUserById(int id);
	public ERSUser getUserByEmail(String email);
	public List<ERSUser> getAllUsers();
	
	public boolean addUser(ERSUser u);
	public boolean updateUser(ERSUser u);
	public boolean removeUser(int userId);
	
	
}
