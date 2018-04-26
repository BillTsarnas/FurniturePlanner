package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class BoxWithShelf implements BoxEntity{
	
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
	
	
	public BoxWithShelf(int boxId,String name, double height, double width, double depth, double thickness, String colour, String door_colour, ArrayList<ExtraParts> extrasK) {
		//super();
		
		//------------------------------------------------------------------------------
		this.boxId = boxId;
		this.name = name;
		
		
		this.extras = extrasK;
		this.pieces = pieces;
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
		
		//create door for box in list index 5
		//-1 is for the "air"
		if (width <= 60) {
			Piece front_door = new Piece(height-0.3, width-0.3, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door);
		}
		else {
			Piece front_door1 = new Piece(height-0.3, (width-0.3)/2, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door1);
			Piece front_door2 = new Piece(height-0.3, (width-0.3)/2, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door2);
			
		}
						
		//shelves go to the rest of the indices
		for(int i = 0; i < num_shelves; i++) {
			Piece shelf = new Piece(depth-1, width-2*thickness, thickness, colour, false,melamine,0);
			pcs.add(shelf);
		}
				
		return pcs;
		
	}
	
	public ArrayList<ExtraParts> calculateExtraParts(ArrayList<ExtraParts> extrasKW, int num_drawers, int num_shelves) {
		
		ArrayList<ExtraParts> extraParts = new ArrayList<ExtraParts>();
		
		if (width <= 60) {
			
			//add 2 handles
			extraParts.add(extrasKW.get(8));
		}
		else {
			
			//add 2 handles
			extraParts.add(extrasKW.get(8));
			extraParts.add(extrasKW.get(8));
		}
		
		for (int i=0; i<num_shelves; i++) {
			//shelf stand
			extraParts.add(extrasKW.get(1));
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
