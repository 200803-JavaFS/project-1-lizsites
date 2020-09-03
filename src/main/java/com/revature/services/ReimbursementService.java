package com.revature.services;

import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.models.LoginDTO;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	public void addReimbursement(Reimbursement r) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		reimbDAO.addReimbursement(r);
	}
	public void updateReimbursement(ReimbDTO reimb) {
		
	}
	public void seeReimbursementsForAuthor(LoginDTO user) {
		
	}
}

