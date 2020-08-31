package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;

public class Proj1LoginService {
	
	private static UserDAO userDAO = new UserDAOImp();
	public boolean login(LoginDTO l) {
		ERSUser u = userDAO.getUserByUsername(l.username);
		System.out.println(u);
		if (u.getPassword().equals(l.password)) {
			return true;
		}
	return false;
	}
}
