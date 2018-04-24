package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Piece {

	private int pieceId;
	private int height;
	private int width;
	private double thickness;
	private String colour;
	private boolean isDoor;
	private Material material;
	private ArrayList<ExtraParts> extras;
	
	public Piece(int pieceId, int height, int width, double thickness, String colour, boolean isDoor, Material material, ArrayList<ExtraParts> extras) {
		super();
		this.pieceId = pieceId;
		this.height = height;
		this.width = width;
		this.thickness = thickness;
		this.colour = colour;
		this.isDoor = isDoor;
		this.material = material;
		this.extras = extras;
	}
	
	public ArrayList<ExtraParts> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<ExtraParts> extras) {
		this.extras = extras;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
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


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	
}
