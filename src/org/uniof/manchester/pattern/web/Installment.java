package org.uniof.manchester.pattern.web;

public class Installment {
	
	int installmentID;
	String paytype;
	double amount;
	
	
	public Installment(int installmentID, String paytype, double amount) {
		super();
		this.installmentID = installmentID;
		this.paytype = paytype;
		this.amount = amount;
	}
	
	
	public int getInstallmentID() {
		return installmentID;
	}
	public void setInstallmentID(int installmentID) {
		this.installmentID = installmentID;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
