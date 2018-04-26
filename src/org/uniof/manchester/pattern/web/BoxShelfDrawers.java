package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class BoxShelfDrawers implements BoxEntity{

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
	
	
	public BoxShelfDrawers(int boxId,String name, double height, double width, double depth, double thickness, String colour, String door_colour, ArrayList<ExtraParts> extrasW) {
		//super();
		
		//------------------------------------------------------------------------------
		this.boxId = boxId;
		this.name = name;
		
		this.pieces = new ArrayList<Piece>();
		this.extras = extrasW;
		
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
		
		//create door for box in list index 5
		// -1 is for the "air"
		if (width <= 60) {
			Piece front_door = new Piece(height - 0.3, width - 0.3, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door);
		} else {
			Piece front_door1 = new Piece(height - 0.3, (width - 0.3) / 2, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door1);
			Piece front_door2 = new Piece(height - 0.3, (width - 0.3) / 2, thickness, door_colour, true, front_mat, 0);
			pcs.add(front_door2);

		}

		// shelves go to the rest of the indices
		for (int i = 0; i < num_shelves; i++) {
			Piece shelf = new Piece(depth - 1, width - 2 * thickness, thickness, colour, false, melamine, 0);
			pcs.add(shelf);
		}
		
		//create inside drawers
		Piece side1 = new Piece(num_drawers * 20, 51, thickness, colour, false, melamine, 0);
		Piece side2 = new Piece(num_drawers * 20, 51, thickness, colour, false, melamine, 0);
		Piece bottom = new Piece(width - 10 - 2 * thickness, 51, this.getBack_thickness(), colour, false, melamine, 0);

		// top -> traverses
		Piece top1 = new Piece(width - 10 - 2 * thickness, 10, thickness, colour, false, melamine, 0);
		Piece top2 = new Piece(width - 10 - 2 * thickness, 10, thickness, colour, false, melamine, 0);

		Piece back = new Piece(width - 10, num_drawers * 20, this.getBack_thickness(), colour, false, melamine, 0);

		pcs.add(side1);
		pcs.add(side2);
		pcs.add(bottom);
		pcs.add(top1);
		pcs.add(top2);
		pcs.add(back);

		for (int i = 0; i < num_drawers; i++) {
			Piece dr_filling = new Piece(num_drawers * 20, 5 - thickness, thickness, colour, false, melamine, 0);
			Piece dr_small_door = new Piece(19.6, width - 10, 1.8, colour, false, front_mat, 0);
			Piece dr_front = new Piece(width - 19, 14, thickness, colour, false, melamine, 0);
			Piece dr_back = new Piece(width - 19, 14, thickness, colour, false, melamine, 0);
			Piece dr_side1 = new Piece(50, 14, thickness, colour, false, melamine, 0);
			Piece dr_side2 = new Piece(50, 14, thickness, colour, false, melamine, 0);
			Piece dr_bottom = new Piece(50, width - 19 + 2 * thickness, this.getBack_thickness(), colour, false,
					melamine, 0);

			pcs.add(dr_filling);
			pcs.add(dr_small_door);
			pcs.add(dr_front);
			pcs.add(dr_back);
			pcs.add(dr_side1);
			pcs.add(dr_side2);
			pcs.add(dr_bottom);

		}

		this.getPieces().addAll(pcs);
		return pcs;	
	}

	public ArrayList<ExtraParts> calculateExtraParts(ArrayList<ExtraParts> extrasKW, int num_drawers, int num_shelves) {
		
		ArrayList<ExtraParts> extraParts = new ArrayList<ExtraParts>();
		
		if (width <= 60) {
			
			//add 1 handles
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
		
		for (int i=0; i<num_drawers; i++) {
			//handles
			extraParts.add(extrasKW.get(1));
		}
		
		this.setExtras(extraParts);
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
