package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_status", schema="public")
public class ReimbursementStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_status_id")
	private int statusId;
	
	@Column(name="reimb_status", nullable=false)
	private String status;
	
	@OneToMany(mappedBy="reimbursementStatus")
	List<Reimbursement> reimbursements;

	public ReimbursementStatus(int statusId, String status, List<Reimbursement> reimbursements) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.reimbursements = reimbursements;
	}

	public ReimbursementStatus() {
		super();
	}

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

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbursements == null) ? 0 : reimbursements.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimbursements == null) {
			if (other.reimbursements != null)
				return false;
		} else if (!reimbursements.equals(other.reimbursements))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
	
}
