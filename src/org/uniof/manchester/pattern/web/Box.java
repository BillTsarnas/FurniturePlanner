package org.uniof.manchester.pattern.web;

public class Box {
	
	private String boxTypeId;
	
	//unit: CM
	private int height;
	private int width;
	private int depth;
	private int sizeInSqMts;
	
	//16 or 18, 16 can be default
	private int thickness;
	
	//thickness of back side set to 80mm
	private double back_thickness = 0.8;
	
	private String colour;
	
	//number of shelves (default 0)
	private int num_shelves;
	
	public Box(String boxTypeId, int height, int width, int depth, int thickness, String colour,
			int num_shelves) {
		super();
		this.boxTypeId = boxTypeId;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.sizeInSqMts = height*width*depth;
		this.thickness = thickness;
		this.colour = colour;
		this.num_shelves = num_shelves;
	}

	public int getSizeInSqMts() {
		return sizeInSqMts;
	}

	public void setSizeInSqMts(int sizeInSqMts) {
		this.sizeInSqMts = sizeInSqMts;
	}

	public String getBoxTypeId() {
		return boxTypeId;
	}

	public void setBoxTypeId(String boxTypeId) {
		this.boxTypeId = boxTypeId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public double getBack_thickness() {
		return back_thickness;
	}

	/*public static void setBack_thickness(double back_thickness) {
		Box.back_thickness = back_thickness;
	}*/

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getNum_shelves() {
		return num_shelves;
	}

	public void setNum_shelves(int num_shelves) {
		this.num_shelves = num_shelves;
	}


}
