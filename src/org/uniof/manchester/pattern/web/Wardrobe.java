package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Wardrobe extends Furniture {
	
	
	private ArrayList<ExtraParts> ward_extraparts;

	public Wardrobe(String name, ArrayList<Box> boxes, ArrayList<ExtraParts> extraparts, ArrayList<Piece> pieces) {
		super(name, 1, "W", boxes, pieces);
	}

	public Wardrobe() {
		super();
	}

	public ArrayList<ExtraParts> getWard_extraparts() {
		return ward_extraparts;
	}

	public void setWard_extraparts(ArrayList<ExtraParts> ward_extraparts) {
		this.ward_extraparts = ward_extraparts;
	}
	
	

}
