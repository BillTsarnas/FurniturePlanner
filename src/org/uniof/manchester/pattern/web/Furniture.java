package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Furniture {

	private String name;
	
	//0 for kitchen, 1 for wardrobe
	private int furnitureId;
	
	private int numOfCuts;
	
	private ArrayList<Box> boxes;
	//private ArrayList<ExtraParts> extraparts;
	//private ArrayList<Materials> materials;
	
	
	public Furniture(String name, int furnitureId, ArrayList<Box> boxes,ArrayList<Materials> materials) {
		super();
		this.name = name;
		this.furnitureId = furnitureId;
		this.numOfCuts = 0; //TODO: to be changed
		this.boxes = boxes;
		//this.materials = materials;
	}
	
	public Furniture() {
		super();
		this.name = "test";
		this.furnitureId = -1;
		this.numOfCuts = 0;
		this.boxes = null;
		//this.materials = null;
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


	/*public ArrayList<Materials> getMaterials() {
		return materials;
	}


	public void setMaterials(ArrayList<Materials> materials) {
		this.materials = materials;
	}*/
	
}
