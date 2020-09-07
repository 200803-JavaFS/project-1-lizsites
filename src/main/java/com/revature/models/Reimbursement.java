package com.revature.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ers_reimbursement", schema = "public" ) 
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="reimbursementId")
public class Reimbursement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_id")
	private int reimbursementId;
	
	@Column(name="reimb_amount", columnDefinition = "NUMERIC(12,2)")
	private double amount;
	
	@Column(name="reimb_submitted", nullable=false)
	private Timestamp timeSubmitted;
	
	@Column(name="reimb_resolved")
	private Timestamp timeResolved;
	
	
	@Column(name="reimb_description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_author")
	private ERSUser ersAuthor;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_resolver")
	private ERSUser ersResolver;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_status_id")
	private ReimbursementStatus reimbursementStatus;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinColumn(name="reimb_type_id")
	private ReimbursementType reimbursementType;

	public Reimbursement(int reimbursementId, double amount, Timestamp timeSubmitted, Timestamp timeResolved,
			String description, ERSUser ersAuthor, ERSUser ersResolver, ReimbursementStatus reimbursementStatus,
			ReimbursementType reimbursementType) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.ersAuthor = ersAuthor;
		this.ersResolver = ersResolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}
	

	public Reimbursement(double amount, Timestamp timeSubmitted, Timestamp timeResolved, String description,
			ERSUser ersAuthor, ERSUser ersResolver, ReimbursementStatus reimbursementStatus,
			ReimbursementType reimbursementType) {
		super();
		this.amount = amount;
		this.timeSubmitted = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.timeResolved = timeResolved;
		this.description = description;
		this.ersAuthor = ersAuthor;
		this.ersResolver = ersResolver;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}


	public Reimbursement() {
		super();
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	
	public void setTimeSubmitted() {
		this.timeSubmitted = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public Timestamp getTimeResolved() {
		return timeResolved;
	}
	
	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}
	public void setTimeResolved() {
		this.timeResolved = new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ERSUser getErsAuthor() {
		return ersAuthor;
	}

	public void setErsAuthor(ERSUser ersAuthor) {
		this.ersAuthor = ersAuthor;
	}

	public ERSUser getErsResolver() {
		return ersResolver;
	}

	public void setErsResolver(ERSUser ersResolver) {
		this.ersResolver = ersResolver;
	}

	public ReimbursementStatus getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public ReimbursementType getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(ReimbursementType reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ersAuthor == null) ? 0 : ersAuthor.hashCode());
		result = prime * result + ((ersResolver == null) ? 0 : ersResolver.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((reimbursementStatus == null) ? 0 : reimbursementStatus.hashCode());
		result = prime * result + ((reimbursementType == null) ? 0 : reimbursementType.hashCode());
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ersAuthor == null) {
			if (other.ersAuthor != null)
				return false;
		} else if (!ersAuthor.equals(other.ersAuthor))
			return false;
		if (ersResolver == null) {
			if (other.ersResolver != null)
				return false;
		} else if (!ersResolver.equals(other.ersResolver))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementStatus == null) {
			if (other.reimbursementStatus != null)
				return false;
		} else if (!reimbursementStatus.equals(other.reimbursementStatus))
			return false;
		if (reimbursementType == null) {
			if (other.reimbursementType != null)
				return false;
		} else if (!reimbursementType.equals(other.reimbursementType))
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", timeSubmitted="
				+ timeSubmitted + ", timeResolved=" + timeResolved + ", description=" + description + ", ersAuthor="
				+ ersAuthor + ", ersResolver=" + ersResolver + ", reimbursementStatus=" + reimbursementStatus
				+ ", reimbursementType=" + reimbursementType + "]";
	}
	
	
	
	
}
