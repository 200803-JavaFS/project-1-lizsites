package com.revature.models;

public class Reimbursement {
	private int reimbursementId;
	private double amount;
	private String timeSubmitted;
	private String timeResolved;
	private String description;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
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
	public String getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public String getTimeResolved() {
		return timeResolved;
	}
	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public Reimbursement(int reimbursementId, double amount, String timeSubmitted, String timeResolved,
			String description, int author, int resolver, int statusId, int typeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement() {
		super();
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", timeSubmitted="
				+ timeSubmitted + ", timeResolved=" + timeResolved + ", description=" + description + ", author="
				+ author + ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
	
	
}
