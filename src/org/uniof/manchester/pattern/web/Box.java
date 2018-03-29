package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Box {
	
	private String boxTypeId;
	
	//unit: CM
	private int height;
	private int width;
	private int depth;
	
	//16 or 18, 16 can be default
	private double thickness;
	
	//thickness of back side set to 80mm
	private static double back_thickness = 0.8;
	
	private String colour;
	
	//number of shelves (default 0)
	private int num_shelves;
	
	//table for "extra" components
	private ArrayList<String> extras;

	public String getBoxTypeId() {
		return boxTypeId;
	}

	public void setBoxTypeId(String boxTypeId) {
		this.boxTypeId = boxTypeId;
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

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public static double getBack_thickness() {
		return back_thickness;
	}

	/*public static void setBack_thickness(double back_thickness) {
		Box.back_thickness = back_thickness;
	}*/

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getNum_shelves() {
		return num_shelves;
	}

	public void setNum_shelves(int num_shelves) {
		this.num_shelves = num_shelves;
	}

	public ArrayList<String> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<String> extras) {
		this.extras = extras;
	}
	
	

}
