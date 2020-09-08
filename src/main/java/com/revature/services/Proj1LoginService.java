package com.revature.services;

import javax.servlet.http.HttpSession;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;

public class Proj1LoginService {
	
	private static UserDAO userDAO = new UserDAOImp();
	public boolean login(LoginDTO l) {
		System.out.println(l.password.hashCode());
		ERSUser u = userDAO.getUserByUsername(l.username);
		System.out.println(u);
		if (u.getPassword().equals(l.password)) {
			return true;
		}
	return false;
	}
}
