package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Order {
	
	private int orderID;
	
	private ArrayList<Furniture> furnitures;
	private Client client;
	
	String status;
	private Installment installment;
	double totalcost;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public ArrayList<Furniture> getFurnitures() {
		return furnitures;
	}
	public void setFurnitures(ArrayList<Furniture> furnitures) {
		this.furnitures = furnitures;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Installment getInstallment() {
		return installment;
	}
	public void setInstallment(Installment installment) {
		this.installment = installment;
	}
	public double getTotal_cost() {
		return totalcost;
	}
	public void setTotal_cost(double total_cost) {
		this.totalcost = total_cost;
	}

}
