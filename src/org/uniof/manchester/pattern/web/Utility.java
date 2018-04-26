package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Utility {

	public ArrayList<Piece> createBoxDefaultPieces(double height, double width, double depth, double thickness, String colour, double back_thickness) {
		
		Material melamine = new Material(0,"melamine", "wood", 0.00075f);
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		Piece top = new Piece(depth, width-2*thickness, thickness, colour, false, melamine,0);
		pcs.add(top);
		Piece bottom = new Piece(depth, width-2*thickness, thickness, colour, false, melamine,0);
		pcs.add(bottom);
		
		Piece side1 = new Piece(height, depth, thickness, colour, false, melamine,0);
		pcs.add(side1);
		Piece side2 = new Piece(height, depth, thickness, colour, false, melamine,0);
		pcs.add(side2);
		
		//create back piece in list index 4
		Piece back = new Piece(height, width, back_thickness, colour, false, melamine,0);
		pcs.add(back);
				
		return pcs;
		
	}
}
