package com.revature.dao;

import java.util.List;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAO {
	public List<ReimbursementType> getAllTypes();
	public boolean addType(ReimbursementType type);
	public boolean updateType(ReimbursementType type);
	public boolean removeType(int typeId);
	ReimbursementType getTypeByTypeName(String Type);
}
