package org.uniof.manchester.pattern.web;

public class ExtraParts {

	private int extraPartId;
	private String name;
	private float cost;
	
	
	public ExtraParts(int extraPartId, String name, float cost) {
		super();
		this.extraPartId = extraPartId;
		this.name = name;
		this.cost = cost;
	}


	public int getExtraPartId() {
		return extraPartId;
	}


	public void setExtraPartId(int extraPartId) {
		this.extraPartId = extraPartId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	
}
