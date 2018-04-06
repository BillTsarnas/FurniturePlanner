package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Furniture {

	
	private int furnitureId;
	private int numextraParts;
	private int numOfCuts;
	
	private ArrayList<Box> boxes;
	private ArrayList<ExtraParts> extraparts;
	private ArrayList<Materials> materials;
	
	
	public Furniture(int furnitureId, int numextraParts, int numOfCuts, ArrayList<Box> boxes,
			ArrayList<ExtraParts> extraparts, ArrayList<Materials> materials) {
		super();
		this.furnitureId = furnitureId;
		this.numextraParts = numextraParts;
		this.numOfCuts = numOfCuts;
		this.boxes = boxes;
		this.extraparts = extraparts;
		this.materials = materials;
	}


	public int getFurnitureId() {
		return furnitureId;
	}


	public void setFurnitureId(int furnitureId) {
		this.furnitureId = furnitureId;
	}


	public int getNumextraParts() {
		return numextraParts;
	}


	public void setNumextraParts(int numextraParts) {
		this.numextraParts = numextraParts;
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


	public ArrayList<ExtraParts> getExtraparts() {
		return extraparts;
	}


	public void setExtraparts(ArrayList<ExtraParts> extraparts) {
		this.extraparts = extraparts;
	}


	public ArrayList<Materials> getMaterials() {
		return materials;
	}


	public void setMaterials(ArrayList<Materials> materials) {
		this.materials = materials;
	}
	
}
