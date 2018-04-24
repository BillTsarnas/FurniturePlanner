package org.uniof.manchester.pattern.web;

public class Materials {
	
	private int materialsId;
	private String name;
	private String colour;
	private float cost;
	
	public Materials(String name, String colour, float cost) {
		super();
		this.materialsId = 0;
		this.name = name;
		this.colour = colour;
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
		return colour;
	}

	public void setColor(String color) {
		this.colour = color;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
