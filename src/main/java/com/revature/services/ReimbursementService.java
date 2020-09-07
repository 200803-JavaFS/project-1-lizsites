package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementStatusDAOImp;
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
	public void updateReimbursement(Reimbursement r) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		reimbDAO.updateReimbursement(r);
	}
	public void seeReimbursementsForAuthor(LoginDTO user) {
		
	}
	
	public List<Reimbursement> seeReimbursementsByStatusId(int id) {
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		ReimbursementStatusDAO statusDAO = new ReimbursementStatusDAOImp();
		return reimbDAO.getReimbursementsByStatus(statusDAO.getStatus(id));
	}
}

