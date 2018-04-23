package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
//import java.util.Iterator;


public class Box {
	
	private String boxTypeId;
	
	//does not need to be inserted into DB, only for calculations
	private ArrayList<Piece> pieces;
	
	//unit: CM
	private int height;
	private int width;
	private int depth;
	private int sizeInSqMts; //total surface size for all the sides combined
	//TODO: Not reliable for cost calculation
	
	//16 or 18, 16 can be default
	private double thickness = 0.16;
	
	//thickness of back side set to 8mm
	private double back_thickness = 0.08;
	
	private String colour;
	
	private boolean hasDoor;
	
	private String door_colour;
	
	
	public Box(String boxTypeId, int height, int width, int depth, int thickness, String colour) {
		super();
		
		//------------------------------------------------------------------------------
		this.boxTypeId = boxTypeId;
		this.height = height; //y
		this.width = width; //x
		this.depth = depth; //z
		this.sizeInSqMts = 0;
		this.thickness = thickness;
		this.colour = colour;
		
		
		//pieces creation
		//ArrayList<Piece> pcs = new ArrayList<Piece>();
		this.pieces = new ArrayList<Piece>();
		
		
		Piece top = new Piece(depth, width-2*thickness, thickness, colour, false);
		this.pieces.add(top);
		Piece bottom = new Piece(depth, width-2*thickness, thickness, colour, false);
		this.pieces.add(bottom);
		
		Piece side1 = new Piece(height, depth, thickness, colour, false);
		this.pieces.add(side1);
		Piece side2 = new Piece(height, depth, thickness, colour, false);
		this.pieces.add(side2);
		
		//create back piece in list index 4
		Piece back = new Piece(height, width, this.back_thickness, colour, false);
		this.pieces.add(back);
		
		//-------------------------------------------------------------------------------
		
		
	}

	public int getSizeInSqMts() {
		return sizeInSqMts;
	}

	public void setSizeInSqMts(int sizeInSqMts) {
		this.sizeInSqMts = sizeInSqMts;
	}

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

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public double getBack_thickness() {
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

	public boolean isHasDoor() {
		return hasDoor;
	}

	public void setHasDoor(boolean hasDoor) {
		this.hasDoor = hasDoor;
	}

	public String getDoor_colour() {
		return door_colour;
	}

	public void setDoor_colour(String door_colour) {
		this.door_colour = door_colour;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	


}
