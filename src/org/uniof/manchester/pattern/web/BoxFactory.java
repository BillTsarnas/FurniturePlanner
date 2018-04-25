package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
import java.util.Iterator;

public class BoxFactory {

	public BoxFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Box createBoxDefault(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour, String door_colour,
			ArrayList<ExtraParts> extrasK, Material mat) {
		
		Box box = new Box(boxId ,boxTypeId, height, width, depth, thickness, colour, door_colour, new ArrayList<Piece>(), extrasK);
		
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
	
	public Box createBoxWithShelf(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,String door_colour,
			ArrayList<ExtraParts> extrasK, Material mat, int num_shelves) {
		
		Box box = createBoxDefault( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour, door_colour,
				extrasK,  mat);
		
		
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		//-------------------------------------------------------------------------------
		
		//create door for box in list index 5
		//-1 is for the "air"
		if (width <= 60) {
			Piece front_door = new Piece(height-0.3, width-0.3, thickness, box.getDoor_colour(), true,mat);
			pcs.add(front_door);
		}
		else {
			Piece front_door1 = new Piece(height-0.3, (width-0.3)/2, thickness, box.getDoor_colour(), true,mat);
			pcs.add(front_door1);
			Piece front_door2 = new Piece(height-0.3, (width-0.3)/2, thickness, box.getDoor_colour(), true,mat);
			pcs.add(front_door2);
			
			//add a handle
			box.getExtras().add(extrasK.get(8));
		}
						
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
			Piece p = piece_itr.next();
			sum += p.getHeight() * p.getWidth();
			//System.out.println("Piece Height:" + p.getHeight() +" Width: " + p.getWidth());
			}
		
		//set size in square meters
		box.setSizeInSqMts(sum);
				
		//sotiria
		
		box.getExtras().add(extrasK.get(8));
		box.getExtras().add(extrasK.get(8));
		box.getExtras().add(extrasK.get(8));
		box.getExtras().add(extrasK.get(8));
		box.getExtras().add(extrasK.get(9));
		
		return box;
		
	}
	
	public Box createBoxFourDrawers(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour, String door_colour,
			ArrayList<ExtraParts> extrasK, Material front_mat) {
		
		
		Box box = createBoxDefault( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour, door_colour,
				extrasK,  front_mat);
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		int num_drawers = 4;
		double space=0.3;
		double drawer_front_height = height/4 - space;
		
		ArrayList<Piece> pcs = new ArrayList<Piece>();
		
		for (int i=0; i<num_drawers; i++) {
			//creation of each drawer
			Piece drawer_front = new Piece(drawer_front_height, width - space, 1.8 , colour, false, front_mat);
			//Piece drawer_front_inside = new Piece(drawer_front_height - 3, width - 4, thickness, colour, false, melamine);
			Piece drawer_back_inside = new Piece(12 - thickness, width - 12, thickness, colour, false, melamine);
			//Piece drawer_side1 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			//Piece drawer_side2 = new Piece(drawer_front_height -3, depth - 5, thickness, colour, false, melamine);
			Piece drawer_bottom = new Piece(width - 11, depth - 6.5, box.getBack_thickness(), colour, false, melamine);
			
			box.getPieces().add(drawer_front);
			//box.getPieces().add(drawer_front_inside);
			box.getPieces().add(drawer_back_inside);
			//box.getPieces().add(drawer_side1);
			//box.getPieces().add(drawer_side2);
			box.getPieces().add(drawer_bottom);
			//extraparts
			
			ArrayList<ExtraParts> ext =  new ArrayList<ExtraParts>();
			//handle
			ext.add(extrasK.get(1));
			//2 drawer drivers with brakes
			ext.add(extrasK.get(2));
			ext.add(extrasK.get(2));
			
			box.setExtras(ext);
			
			
		}
		
		return box;
		
	}
	
	public Box createBoxWithBar(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour, String door_colour,
			ArrayList<ExtraParts> extrasK, Material mat, int num_shelves) {
		
		//create box with two shelves
		Box box = createBoxWithShelf( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour, door_colour,
				extrasK,  mat, num_shelves);
		
		//bar
		box.getExtras().add(extrasK.get(1));
		
		return box;
	}
	
	public Box createBoxShelfDrawers(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour, String door_colour,
			ArrayList<ExtraParts> extrasK, Material mat, int num_shelves, int num_drawers) {
		
		//create box with four shelves
		Box box = createBoxWithShelf( boxId,  boxTypeId,  height,  width,  depth,  thickness,  colour, door_colour,
				extrasK,  mat, num_shelves);
		
		Material melamine = new Material("melamine", "wood", 0.00075f);
		
		//create inside drawers
		Piece side1 = new Piece(num_drawers*20, 51, thickness , colour, false, melamine);
		Piece side2 = new Piece(num_drawers*20, 51, thickness , colour, false, melamine);
		Piece bottom = new Piece(width-10-2*thickness, 51, box.getBack_thickness() , colour, false, melamine);
		
		//top -> traverses
		Piece top1 = new Piece(width-10-2*thickness, 10, thickness , colour, false, melamine);
		Piece top2 = new Piece(width-10-2*thickness, 10, thickness , colour, false, melamine);
		
		Piece back = new Piece(width-10, num_drawers*20, box.getBack_thickness() , colour, false, melamine);
		
		box.getPieces().add(side1);
		box.getPieces().add(side2);
		box.getPieces().add(bottom);
		box.getPieces().add(top1);
		box.getPieces().add(top2);
		box.getPieces().add(back);
		
		for(int i=0; i<num_drawers; i++) {
			Piece dr_filling = new Piece(num_drawers*20, 5-thickness, thickness , colour, false, melamine);
			Piece dr_small_door = new Piece(19.6, width-10, 1.8 , colour, false, mat);
			Piece dr_front = new Piece(width-19, 14, thickness , colour, false, melamine);
			Piece dr_back = new Piece(width-19, 14, thickness , colour, false, melamine);
			Piece dr_side1 = new Piece(50, 14, thickness , colour, false, melamine);
			Piece dr_side2 = new Piece(50, 14, thickness , colour, false, melamine);
			Piece dr_bottom = new Piece(50, width-19+2*thickness, box.getBack_thickness() , colour, false, melamine);
			
			box.getPieces().add(dr_filling);
			box.getPieces().add(dr_small_door);
			box.getPieces().add(dr_front);
			box.getPieces().add(dr_back);
			box.getPieces().add(dr_side1);
			box.getPieces().add(dr_side2);
			box.getPieces().add(dr_bottom);
			
			
			//extras for each drawer
			//simple drawer drivers 50cm
			box.getExtras().add(extrasK.get(1));
			
		}
		
		
		//bar
		box.getExtras().add(extrasK.get(1));
		
		return box;
	}

}
