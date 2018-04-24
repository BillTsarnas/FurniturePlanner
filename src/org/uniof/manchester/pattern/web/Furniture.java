package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Furniture {

	private String name;
	
	private int furnitureId;
	
	private String type; //K for Kitchen W for Wardrobe
	
	private ArrayList<Box> boxes;
	
	private ArrayList<Piece> pieces;
	
	
	public Furniture(String name, int furnitureId, String type, ArrayList<Box> boxes, ArrayList<Piece> pieces) {
		super();
		this.name = name;
		this.furnitureId = furnitureId;
		this.type = type;
		this.boxes = boxes;
		this.pieces = pieces;
	}
	
	public Furniture() {
		super();
		this.name = "test";
		this.furnitureId = -1;
		this.boxes = null;
	}
	
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
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

	public ArrayList<Box> getBoxes() {
		return boxes;
	}


	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	
}
