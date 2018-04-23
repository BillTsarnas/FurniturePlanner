package org.uniof.manchester.pattern.web;

import java.util.Iterator;

public class BoxOneShelf extends Box {
	

	private int num_shelves;

	public BoxOneShelf(int boxId, String boxTypeId, int height, int width, int depth, int thickness, String colour,
			int num_shelves) {
		
		super(boxId ,boxTypeId, height, width, depth, thickness, colour);
		this.setNum_shelves(num_shelves);
		
		//create door for box in list index 5
		//-1 is for the "air"
		Piece p = new Piece(height-1, width-1, thickness, this.getDoor_colour(), true);
		this.getPieces().add(p);
				
		//shelves go to the rest of the indices
		for(int i = 0; i < num_shelves; i++) {
			Piece shelf = new Piece(depth-1, width-2*thickness, thickness, colour, false);
			this.getPieces().add(shelf);
		}
				
		int sum = 0;
				
		Iterator<Piece> piece_itr = this.getPieces().iterator();
		while(piece_itr.hasNext()) {
			p = piece_itr.next();
			sum += p.getHeight() * p.getWidth();
			System.out.println("Piece Height:" + p.getHeight() +" Width: " + p.getWidth());
			}
		this.setSizeInSqMts(sum);
	}

	public int getNum_shelves() {
		return num_shelves;
	}

	public void setNum_shelves(int num_shelves) {
		this.num_shelves = num_shelves;
	}

}
