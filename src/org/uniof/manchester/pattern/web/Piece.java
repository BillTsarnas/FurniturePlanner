package org.uniof.manchester.pattern.web;

public class Piece {

	private int pieceId;
	private double height;
	private double width;
	private double thickness;
	private String colour;
	private boolean isDoor;
	
	private Material material;
	
	
	public Piece(double height, double width, double thickness, String colour, boolean isDoor, Material material, int pieceId) {
		super();
		this.pieceId = pieceId;
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


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getThickness() {
		return thickness;
	}


	public void setThickness(double thickness) {
		this.thickness = thickness;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public boolean isDoor() {
		return isDoor;
	}


	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	
	
}
