package com.revature.models;

import java.io.Serializable;

public class ReimbursementType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeId;
	private String type;
	
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ReimbursementType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	public ReimbursementType() {
		super();
	}
	@Override
	public String toString() {
		return "ReimbursementType [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
	
	
}
