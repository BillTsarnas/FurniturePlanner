package org.uniof.manchester.pattern.web;

import java.util.ArrayList;
import java.util.Iterator;

public class BoxOneShelf extends Box {
	

	private int num_shelves=1;

	public BoxOneShelf(int boxId, String boxTypeId, double height, double width, double depth, double thickness, String colour,
			ArrayList<ExtraParts> extrasK, Material mat) {
		
		//create side, bottom pieces and back piece
		super(boxId ,boxTypeId, height, width, depth, thickness, colour, extrasK);
		this.setNum_shelves(1);
		/*
		Materials melamine = new Materials("melamine", "wood", 0.00075f);
		
		//create door for box in list index 5
		//-1 is for the "air"
		Piece p = new Piece(height-1, width-1, thickness, this.getDoor_colour(), true,mat);
		this.getPieces().add(p);
				
		//shelves go to the rest of the indices
		for(int i = 0; i < num_shelves; i++) {
			Piece shelf = new Piece(depth-1, width-2*thickness, thickness, colour, false,melamine);
			this.getPieces().add(shelf);
		}
		
		//Calculate total size of square meters
		int sum = 0;
				
		Iterator<Piece> piece_itr = this.getPieces().iterator();
		while(piece_itr.hasNext()) {
			p = piece_itr.next();
			sum += p.getHeight() * p.getWidth();
			System.out.println("Piece Height:" + p.getHeight() +" Width: " + p.getWidth());
			}
		this.setSizeInSqMts(sum);
		
		//sotiria
		this.getExtras().add(extrasK.get(8));
		this.getExtras().add(extrasK.get(8));
		this.getExtras().add(extrasK.get(8));
		this.getExtras().add(extrasK.get(8));
		this.getExtras().add(extrasK.get(9));*/
		/*this.getExtras().add(1);
		this.getExtras().add(4);*/
		
	}

	public int getNum_shelves() {
		return num_shelves;
	}

	public void setNum_shelves(int num_shelves) {
		this.num_shelves = num_shelves;
	}

}
