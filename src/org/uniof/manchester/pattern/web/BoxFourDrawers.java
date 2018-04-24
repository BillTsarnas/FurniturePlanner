package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class BoxFourDrawers extends Box {
	

	public BoxFourDrawers(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,
			ArrayList<ExtraParts> extrasK, Material front_mat) {
		
		//create side, bottom pieces and back piece
		super(boxId, boxTypeId, height, width, depth, thickness, colour, extrasK);
		
		/*Material melamine = new Material("melamine", "wood", 0.00075f);
		
		
		double space=0.5;
		double drawer_front_height = (height - 5 * space) / 4;
		
		for (int i=0; i<4; i++) {
			//creation of each drawer
			Piece drawer_front = new Piece(drawer_front_height, width, thickness, colour, false, front_mat);
			
			Piece drawer_front_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_back_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_side1 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_side2 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_bottom = new Piece(width - 4, depth - 5 + 2*thickness, this.getBack_thickness(), colour, false, melamine);
			
			this.getPieces().add(drawer_front_inside);
			this.getPieces().add(drawer_back_inside);
			this.getPieces().add(drawer_side1);
			this.getPieces().add(drawer_side2);
			this.getPieces().add(drawer_bottom);
			//extraparts
			
			//handle
			this.getExtras().add(extrasK.get(1));
			//2 drawer drivers
			this.getExtras().add(extrasK.get(2));
			this.getExtras().add(extrasK.get(2));
			
		}*/
		
		
	}

}
