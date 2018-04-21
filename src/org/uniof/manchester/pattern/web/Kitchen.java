package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public class Kitchen extends Furniture {
	
	//kitchen furniture id: 0
	
	public Kitchen(ArrayList<Box> boxes,
			ArrayList<ExtraParts> extraparts, ArrayList<Materials> materials) {
		super(0, boxes, extraparts, materials);
	}

	public Kitchen() {
		// TODO Auto-generated constructor stub
		super();
	}


}
