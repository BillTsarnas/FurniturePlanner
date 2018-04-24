package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Wardrobe extends Furniture {
	
	//wardrobe furniture id: 1
	
	private ArrayList<ExtraParts> ward_extraparts;

	public Wardrobe(String name, ArrayList<Box> boxes, ArrayList<ExtraParts> extraparts, ArrayList<Material> material) {
		super(name, 1, 0, boxes);
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
