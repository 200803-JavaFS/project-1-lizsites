package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;

public interface ReimbursementStatusDAO {
	public List<ReimbursementStatus> getAllStatuses();
	public boolean addStatus(ReimbursementStatus status);
	public boolean updateStatus(ReimbursementStatus status);
	public boolean removeStatus(int statusId);
	public ReimbursementStatus getStatusByStatusName(String name);
	
}
