package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
//import java.util.Iterator;


public class Box {
	
	private String name;
	private int boxId;
	
	//does not need to be inserted into DB, only for calculations
	private ArrayList<Piece> pieces;
	
	private ArrayList<ExtraParts> extras;
	
	//unit: CM
	private double height;
	private double width;
	private double depth;
	private double sizeInSqMts; //total surface size for all the sides combined
	//TODO: Not reliable for cost calculation
	
	//16 or 18, 16 can be default
	private double thickness = 0.16;
	
	//thickness of back side set to 8mm
	private double back_thickness = 0.08;
	
	private String colour;
	
	private boolean hasDoor;
	
	private String door_colour;
	
	
	public Box(int boxId,String boxTypeId, double height, double width, double depth, double thickness, String colour, ArrayList<ExtraParts> extrasK) {
		super();
		
		//------------------------------------------------------------------------------
		this.name = boxTypeId;
		this.height = height; //y
		this.width = width; //x
		this.depth = depth; //z
		this.sizeInSqMts = 0;
		this.thickness = thickness;
		this.colour = colour;
		
		
		//pieces creation
		//ArrayList<Piece> pcs = new ArrayList<Piece>();
		this.pieces = new ArrayList<Piece>();
		
		//this.extras = new ArrayList<ExtraParts>();
		Materials melamine = new Materials("melamine", "wood", 1.5f);
		
		Piece top = new Piece(depth, width-2*thickness, thickness, colour, false, melamine);
		this.pieces.add(top);
		Piece bottom = new Piece(depth, width-2*thickness, thickness, colour, false, melamine);
		this.pieces.add(bottom);
		
		Piece side1 = new Piece(height, depth, thickness, colour, false, melamine);
		this.pieces.add(side1);
		Piece side2 = new Piece(height, depth, thickness, colour, false, melamine);
		this.pieces.add(side2);
		
		//create back piece in list index 4
		Piece back = new Piece(height, width, this.back_thickness, colour, false, melamine);
		this.pieces.add(back);
		
		//-------------------------------------------------------------------------------
		
		//add the extras for the box
		this.extras = extrasK;
		
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBoxId() {
		return boxId;
	}


	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}


	public ArrayList<Piece> getPieces() {
		return pieces;
	}


	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}


	public ArrayList<ExtraParts> getExtras() {
		return extras;
	}


	public void setExtras(ArrayList<ExtraParts> extras) {
		this.extras = extras;
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


	public double getDepth() {
		return depth;
	}


	public void setDepth(double depth) {
		this.depth = depth;
	}


	public double getSizeInSqMts() {
		return sizeInSqMts;
	}


	public void setSizeInSqMts(double sizeInSqMts) {
		this.sizeInSqMts = sizeInSqMts;
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
	
	


}
