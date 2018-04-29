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
	private double sizeInSqMts; //currently is the cost of each box
	
	//16 or 18, 16 can be default
	private double thickness = 1.6;
	
	//thickness of back side set to 8mm
	private double back_thickness = 0.8;
	
	private String colour;
	
	private String door_colour;
	
	
	public Box(int boxId,String name, double height, double width, double depth, double thickness, String colour, String door_colour, ArrayList<Piece> pieces, ArrayList<ExtraParts> extras) {
		super();
		
		//------------------------------------------------------------------------------
		this.boxId = boxId;
		this.name = name;
		
		this.pieces = pieces;
		this.extras = extras;
		
		this.height = height; //y
		this.width = width; //x
		this.depth = depth; //z
		this.sizeInSqMts = 0;
		this.thickness = thickness;
		this.colour = colour;
		this.door_colour = door_colour;
				
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


	public String getDoor_colour() {
		return door_colour;
	}


	public void setDoor_colour(String door_colour) {
		this.door_colour = door_colour;
	}


	public double getBack_thickness() {
		return back_thickness;
	}


	public void setBack_thickness(double back_thickness) {
		this.back_thickness = back_thickness;
	}
	
	


}
