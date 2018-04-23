package org.uniof.manchester.pattern.web;

public class Piece {

	int height;
	int width;
	private double thickness;
	
	String colour;
	boolean isDoor;
	
	
	
	public Piece(int height, int width, double thickness, String colour, boolean isDoor) {
		super();
		this.height = height;
		this.width = width;
		this.thickness = thickness;
		this.colour = colour;
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
	
}
