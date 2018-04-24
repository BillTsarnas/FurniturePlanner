package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Furniture {

	private String name;
	
	private int furnitureId;
	
	private int numOfCuts;
	
	private ArrayList<Box> boxes;
	
	
	public Furniture(String name, int furnitureId, int numOfCuts, ArrayList<Box> boxes) {
		super();
		this.name = name;
		this.furnitureId = furnitureId;
		this.numOfCuts = numOfCuts; //TODO: to be changed
		this.boxes = boxes;
	}
	
	public Furniture() {
		super();
		this.name = "test";
		this.furnitureId = -1;
		this.numOfCuts = 0;
		this.boxes = null;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFurnitureId() {
		return furnitureId;
	}


	public void setFurnitureId(int furnitureId) {
		this.furnitureId = furnitureId;
	}


	public int getNumOfCuts() {
		return numOfCuts;
	}


	public void setNumOfCuts(int numOfCuts) {
		this.numOfCuts = numOfCuts;
	}


	public ArrayList<Box> getBoxes() {
		return boxes;
	}


	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	
}
