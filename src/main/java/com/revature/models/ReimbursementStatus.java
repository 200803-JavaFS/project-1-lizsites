package com.revature.models;

import java.io.Serializable;

public class ReimbursementStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusId;
	private String status;
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	
	
	public ReimbursementStatus() {
		super();
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
	
}
