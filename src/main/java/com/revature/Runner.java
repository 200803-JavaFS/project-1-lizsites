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
//		for (ERSUser ers : u) {
//			System.out.println(ers.getPassword().hashCode());
//			ers.setPassword(Integer.toString(ers.getPassword().hashCode()));
//			if (userDAO.updateUser(ers)) {
//			System.out.println(ers);
//			}else {
//				System.out.println("error");
//			}
//		}
//		
		
	
//		System.out.println(userDAO.getUserByUsername("melia23"));
//		List<Reimbursement> reimb = reimbDAO.getReimbursementsByAuthor(u.get(0));
//		for (Reimbursement r : reimb) {
//			System.out.println(r);
//		}
		List<Reimbursement> allReimbs = reimbDAO.getReimbursements();
		for (Reimbursement q : allReimbs) {
			System.out.println(q);
		}
	}
}
