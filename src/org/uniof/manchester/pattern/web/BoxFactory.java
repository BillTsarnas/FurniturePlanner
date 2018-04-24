package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
import java.util.Iterator;

public class BoxFactory {

	public BoxFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Box createBoxDefault(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,
			ArrayList<ExtraParts> extrasK, Material mat) {
		
		Box box = new Box(boxId ,boxTypeId, height, width, depth, thickness, colour, extrasK);
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		Piece top = new Piece(depth, width-2*thickness, thickness, colour, false, melamine);
		pcs.add(top);
		Piece bottom = new Piece(depth, width-2*thickness, thickness, colour, false, melamine);
		pcs.add(bottom);
		
		Piece side1 = new Piece(height, depth, thickness, colour, false, melamine);
		pcs.add(side1);
		Piece side2 = new Piece(height, depth, thickness, colour, false, melamine);
		pcs.add(side2);
		
		//create back piece in list index 4
		Piece back = new Piece(height, width, box.getBack_thickness(), colour, false, melamine);
		pcs.add(back);
		
		box.setPieces(pcs);
		
		return box;
		
	}
	
	public Box createBoxOneShelf(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,
			ArrayList<ExtraParts> extrasK, Material mat) {
		
		Box box = createBoxDefault( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour,
				extrasK,  mat);
		
		int num_shelves=1;
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		//-------------------------------------------------------------------------------
		
		//create door for box in list index 5
		//-1 is for the "air"
		Piece p = new Piece(height-1, width-1, thickness, box.getDoor_colour(), true,mat);
		pcs.add(p);
						
		//shelves go to the rest of the indices
		for(int i = 0; i < num_shelves; i++) {
			Piece shelf = new Piece(depth-1, width-2*thickness, thickness, colour, false,melamine);
			pcs.add(shelf);
		}
				
		//update the pieces of the object
		box.getPieces().addAll(pcs);
		
		//Calculate total size of square meters
		int sum = 0;
						
		Iterator<Piece> piece_itr = pcs.iterator();
		while(piece_itr.hasNext()) {
			p = piece_itr.next();
			sum += p.getHeight() * p.getWidth();
			//System.out.println("Piece Height:" + p.getHeight() +" Width: " + p.getWidth());
			}
		
		//set size in square meters
		box.setSizeInSqMts(sum);
				
		//sotiria
		
		ArrayList<ExtraParts> ext =  new ArrayList<ExtraParts>();
		ext.add(extrasK.get(8));
		ext.add(extrasK.get(8));
		ext.add(extrasK.get(8));
		ext.add(extrasK.get(8));
		ext.add(extrasK.get(9));
		
		box.setExtras(ext);
		
		return box;
		
	}
	
	public Box createBoxFourDrawers(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,
			ArrayList<ExtraParts> extrasK, Material front_mat) {
		
		
		Box box = createBoxDefault( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour,
				extrasK,  front_mat);
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		
		double space=0.5;
		double drawer_front_height = (height - 5 * space) / 4;
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		for (int i=0; i<4; i++) {
			//creation of each drawer
			Piece drawer_front = new Piece(drawer_front_height, width, thickness, colour, false, front_mat);
			Piece drawer_front_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_back_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_side1 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_side2 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_bottom = new Piece(width - 4, depth - 5 + 2*thickness, box.getBack_thickness(), colour, false, melamine);
			
			box.getPieces().add(drawer_front);
			box.getPieces().add(drawer_front_inside);
			box.getPieces().add(drawer_back_inside);
			box.getPieces().add(drawer_side1);
			box.getPieces().add(drawer_side2);
			box.getPieces().add(drawer_bottom);
			//extraparts
			
			ArrayList<ExtraParts> ext =  new ArrayList<ExtraParts>();
			//handle
			ext.add(extrasK.get(1));
			//2 drawer drivers
			ext.add(extrasK.get(2));
			ext.add(extrasK.get(2));
			
			box.setExtras(ext);
			
			
		}
		
		return box;
		
	}

}
