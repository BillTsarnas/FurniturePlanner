package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Kitchen extends Furniture {
	
	//arraylist of extraparts specific for one kitchen
	private ArrayList<ExtraParts> kitch_extraparts;
	
	//kitchen furniture id: 0
	
	public Kitchen(String name, ArrayList<Box> boxes,
			ArrayList<ExtraParts> extraparts, ArrayList<Material> material) {
		super(name, 0,0, boxes);
	}

	public Kitchen() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ArrayList<ExtraParts> getKitch_extraparts() {
		return kitch_extraparts;
	}

	public void setKitch_extraparts(ArrayList<ExtraParts> extraparts) {
		this.kitch_extraparts = extraparts;
	}
	
	


}
