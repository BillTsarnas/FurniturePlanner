package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Order {

	private int orderID;
    private ArrayList<Furniture> furnitures;
	private ArrayList<Installment> installments;
	private int clientId;
	String status;
	String name;
	float totalcost;
	



	public Order(int orderID, ArrayList<Furniture> furnitures, int  clientId, String status, ArrayList<Installment> installments,
			float totalcost, String name) {
		this.orderID = orderID;
		this.furnitures = furnitures;
		this.clientId = clientId;
		this.status = status;
		this.installments = installments;
		this.totalcost = totalcost;
		this.name = name;
	}
	
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal_cost() {
		return totalcost;
	}

	
	public ArrayList<Installment> getInstallments() {
		return installments;
	}


	public void setInstallments(ArrayList<Installment> installments) {
		this.installments = installments;
	}
	
	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
