package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class BoxWithDrawers implements BoxEntity{
	
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
	
	//16 or 18, 16 can be default
	private double thickness = 1.6;
	
	//thickness of back side set to 8mm
	private double back_thickness = 0.8;
	
	private String colour;
	
	private String door_colour;
	
	
	public BoxWithDrawers(int boxId,String name, double height, double width, double depth, double thickness, String colour, String door_colour, ArrayList<ExtraParts> extrasK) {
		//super();
		
		//------------------------------------------------------------------------------
		this.boxId = boxId;
		this.name = name;
		
		this.pieces = pieces;
		this.extras = extrasK;
		
		this.height = height; //y
		this.width = width; //x
		this.depth = depth; //z
		this.sizeInSqMts = 0;
		this.thickness = thickness;
		this.colour = colour;
		this.door_colour = door_colour;
		
	}

	public ArrayList<Piece> calculatePieces(double height, double width, double depth, double thickness, String colour, String door_colour,
			String mat, int num_shelves, int num_drawers) {
		
		Material melamine = new Material(0,"melamine", colour, 0.00075f);
		
		Material front_mat = new Material(0, mat, door_colour, 0.00075f);
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		//-------------------------------------------------------------------------------
		
		//int num_drawers = 4;
		double space=0.3;
		double drawer_front_height = height/4 - space;
		
		
		for (int i=0; i<num_drawers; i++) {
			//creation of each drawer
			Piece drawer_front = new Piece(drawer_front_height, width - space, 1.8 , colour, false, front_mat,0);
			//Piece drawer_front_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_back_inside = new Piece(12 - thickness, width - 12, thickness, colour, false, melamine,0);
			//Piece drawer_side1 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			//Piece drawer_side2 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_bottom = new Piece(width - 11, depth - 6.5, this.getBack_thickness(), colour, false, melamine,0);
			
			pcs.add(drawer_front);
			//box.getPieces().add(drawer_front_inside);
			pcs.add(drawer_back_inside);
			//box.getPieces().add(drawer_side1);
			//box.getPieces().add(drawer_side2);
			pcs.add(drawer_bottom);
		
		}
		return pcs;
		
	}
	
	public ArrayList<ExtraParts> calculateExtraParts(ArrayList<ExtraParts> extrasKW, int num_drawers, int num_shelves) {
		
		ArrayList<ExtraParts> extraParts = new ArrayList<ExtraParts>();
		
		for (int i=0; i<num_drawers; i++) {
			//handle
			extraParts.add(extrasKW.get(1));
			//2 drawer drivers with brakes
			extraParts.add(extrasKW.get(2));
			extraParts.add(extrasKW.get(2));
		}
		
		return extraParts;
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


	public double getBack_thickness() {
		return back_thickness;
	}


	public void setBack_thickness(double back_thickness) {
		this.back_thickness = back_thickness;
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

}
