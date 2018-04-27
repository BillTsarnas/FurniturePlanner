package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
import java.util.Iterator;

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
	
public void calculateTotalCost(Order order) {
		
		//set up furniture list
		ArrayList<Furniture> furList = order.getFurnitures();
		//set up furniture iterator
		Iterator<Furniture> furnIt = furList.iterator();
		
		//set up box list
		ArrayList<Box> boxList = new ArrayList<Box>();
		//set up box iterator
		Iterator<Box> boxIt;
		
		//set up piece list
		ArrayList<Piece> pieceList = new ArrayList<Piece>(); 
		//set up piece iterator
		Iterator<Piece> pieceIt;
		
		float totalCost = 0.0f;
		
		while (furnIt.hasNext()) {

			Furniture currF = furnIt.next();
			boxList = currF.getBoxes();
 			boxIt = boxList.iterator();
 			
 			while (boxIt.hasNext()) {

 				Box currB = boxIt.next();
 				pieceList = currB.getPieces();
 				pieceIt = pieceList.iterator();
 				
 	 			while (boxIt.hasNext()) {

 	 				Piece currP = pieceIt.next();
 	 				totalCost = (float) ((float) currP.getHeight()*currP.getWidth()*currP.getThickness()*currP.getMaterial().getCost());
 	 	    	}
 	    	}
 			
    	}
				
		order.setTotalcost(totalCost);
		
	}
}
