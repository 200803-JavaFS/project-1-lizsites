package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementStatusDAOImp;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	public List<Reimbursement> seeReimbursements(ERSUser u){
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		List<Reimbursement> reimbs;
		if (u.getUserrole().getRoleName().equals("admin")) {
			reimbs = reimbDAO.getReimbursements();
		} else {
		reimbs = reimbDAO.getReimbursementsByAuthor(u);
		}
		return reimbs;
	}
	
	public boolean addReimbursement(Reimbursement r) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		return reimbDAO.addReimbursement(r);
	}
	public boolean updateReimbursement(Reimbursement r) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		return reimbDAO.updateReimbursement(r);
	
		
	}
	public void seeReimbursementsForAuthor(LoginDTO user) {
		
	}
	
	public List<Reimbursement> seeReimbursementsByStatusId(int id) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		ReimbursementStatusDAO statusDAO = new ReimbursementStatusDAOImp();
		return reimbDAO.getReimbursementsByStatus(statusDAO.getStatus(id));
	}
}

