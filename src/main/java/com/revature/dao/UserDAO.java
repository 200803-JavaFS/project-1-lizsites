package com.revature.dao;

import java.util.Set;

import com.revature.models.ERSUser;

public interface UserDAO {
	public ERSUser getUserByUsername(String username);
	public ERSUser getUserById(int id);
	public Set<ERSUser> getAllUsers();
}
