package org.uniof.manchester.pattern.web;

public class Materials {
	
	private int materialsId;
	private String name;
	private String coluor;
	private float cost;
	
	public Materials(int materialsId, String name, String colour, float cost) {
		super();
		this.materialsId = materialsId;
		this.name = name;
		this.coluor = colour;
		this.cost = cost;
	}

	public int getMaterialsId() {
		return materialsId;
	}

	public void setMaterialsId(int materialsId) {
		this.materialsId = materialsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return coluor;
	}

	public void setColor(String color) {
		this.coluor = color;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
