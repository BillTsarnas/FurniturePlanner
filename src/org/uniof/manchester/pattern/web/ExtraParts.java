package org.uniof.manchester.pattern.web;

public class ExtraParts {

	private int extraPartId;
	private String name;
	private float cost;
	private String type;
	private int numof;
	
	
	public ExtraParts(int extraPartId, String name, float cost, String type, int numof) {
		super();
		this.extraPartId = extraPartId;
		this.name = name;
		this.cost = cost;
		this.numof = numof;
	}

	

	public int getNumof() {
		return numof;
	}



	public void setNumof(int numof) {
		this.numof = numof;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
