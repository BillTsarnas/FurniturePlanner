package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class BoxFactory {

	public BoxFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public BoxEntity createBox(String boxType, double height, double width, double depth, double thickness, String colour, String door_colour, ArrayList<ExtraParts> extrasKW, String mat, String FurType){
	    
		Utility default_pieces  = new Utility();
		
		if(FurType.equalsIgnoreCase("Kitchen")) {
			if (boxType == null) {
				return null;
			}
			if (boxType.equalsIgnoreCase("Box with shelf")) {
				
				//create the box of category BoxWithShelf
				BoxWithShelf box = new BoxWithShelf(0, boxType, height, width, depth, thickness, colour, door_colour, extrasKW);
				//calculate and set the default pieces
				box.getPieces().addAll(default_pieces.createBoxDefaultPieces(height, width, depth, thickness, colour, box.getBack_thickness()));
				//calculate the special pieces
				box.calculatePieces(height, width, depth, thickness, colour, door_colour, mat, 1, 0);
				//System.out.println("Mphka!!!!!!!");
				//set the extra parts
				box.calculateExtraParts(extrasKW, 0, 1);
				return box;
						
			} else if (boxType.equalsIgnoreCase("Box with 3 drawers")) {
				//create the box of category BoxWithDrawers
				BoxWithDrawers box = new BoxWithDrawers(0, boxType, height, width, depth, thickness, colour, door_colour, extrasKW);
				//calculate and set the default pieces
				box.getPieces().addAll(default_pieces.createBoxDefaultPieces(height, width, depth, thickness, colour, box.getBack_thickness()));
				//calculate the special pieces
				box.calculatePieces(height, width, depth, thickness, colour, door_colour, mat, 0, 3);
				//set the extra parts
				box.calculateExtraParts(extrasKW, 3, 0);
				return box;

			} else if (boxType.equalsIgnoreCase("Box with 4 drawers")) {
				//create the box of category BoxWithDrawers
				BoxWithDrawers box = new BoxWithDrawers(0, boxType, height, width, depth, thickness, colour, door_colour, extrasKW);
				//calculate and set the default pieces
				box.getPieces().addAll(default_pieces.createBoxDefaultPieces(height, width, depth, thickness, colour, box.getBack_thickness()));
				//calculate the special pieces
				box.calculatePieces(height, width, depth, thickness, colour, door_colour, mat, 0, 4);
				//set the extra parts
				box.calculateExtraParts(extrasKW, 4, 0);
				return box;
			}

			else
				return null;
		}
		else if (FurType.equalsIgnoreCase("Wardrobe")) {
			if (boxType == null) {
				return null;
			}
			if (boxType.equalsIgnoreCase("Box with bar and 2 shelves")) {
				//create the box of category BoxWithBar
				BoxWithBar box = new BoxWithBar(0, boxType, height, width, depth, thickness, colour, door_colour, extrasKW);
				//calculate and set the default pieces
				box.getPieces().addAll(default_pieces.createBoxDefaultPieces(height, width, depth, thickness, colour, box.getBack_thickness()));
				//calculate the special pieces
				box.calculatePieces(height, width, depth, thickness, colour, door_colour, mat, 2, 0);
				//set the extra parts
				box.calculateExtraParts(extrasKW, 0, 2);
				return box;

			} else if (boxType.equalsIgnoreCase("Box with 4 shelves and a set of 4 drawers")) {
				//create the box of category BoxShelfDrawers
				BoxShelfDrawers box = new BoxShelfDrawers(0, boxType, height, width, depth, thickness, colour, door_colour, extrasKW);
				//calculate and set the default pieces
				box.getPieces().addAll(default_pieces.createBoxDefaultPieces(height, width, depth, thickness, colour, box.getBack_thickness()));
				//calculate the special pieces
				box.calculatePieces(height, width, depth, thickness, colour, door_colour, mat, 4, 4);
				//set the extra parts
				box.calculateExtraParts(extrasKW, 4, 4);
				return box;
			}

			else
				return null;
		}
		
		else	
			return null;
	}

}
