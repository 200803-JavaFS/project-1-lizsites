package com.revature;

import java.util.List;
import java.util.Set;

import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.UserRoles;

public class Runner {
	public static void main(String[] args) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		UserDAO userDAO = new UserDAOImp();
		
		List<ERSUser> u = userDAO.getAllUsers();
		System.out.println(u.get(0));
		UserRoles role = u.get(0).getUserrole();
		System.out.println(role);
		
	
		System.out.println(reimbDAO.getReimbursementsByAuthor(u.get(0)));
		
	}
}
