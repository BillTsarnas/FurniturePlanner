package org.uniof.manchester.pattern.web;

public class Piece {

	private int pieceId;
	private int height;
	private int width;
	private double thickness;
	private String colour;
	private boolean isDoor;
	
	private Materials material;
	
	
	public Piece(int height, int width, double thickness, String colour, boolean isDoor, Materials material) {
		super();
		this.height = height;
		this.width = width;
		this.thickness = thickness;
		this.colour = colour;
		this.isDoor = isDoor;
		this.material = material;
	}
	
	
	public int getPieceId() {
		return pieceId;
	}

	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}

	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public boolean getIsDoor() {
		return isDoor;
	}
	public void setIsDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}


	public Materials getMaterial() {
		return material;
	}


	public void setMaterial(Materials material) {
		this.material = material;
	}
	
	
	
}
