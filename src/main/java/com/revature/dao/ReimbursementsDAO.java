package com.revature.dao;

import java.util.List;
import java.util.Set;

import com.revature.models.ERSUser;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

public interface ReimbursementsDAO {
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsByAuthor(ERSUser u);
	public List<Reimbursement> getReimbursementsByStatus(ReimbursementStatus status);
	public List<Reimbursement> getReimbursementsByType(ReimbursementType type);
	
	public Reimbursement getReimbursement(int id);
	
	
	public boolean addReimbursement(Reimbursement reimbursement);
	public boolean updateReimbursement(Reimbursement reimbursement);
	public boolean removeReimbursement(int reimbursementId);
	
}
