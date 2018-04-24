package org.uniof.manchester.pattern.web;

//import java.util.Iterator;


public class Box {
	
	private String name;
	private int boxId;
	private String type;
	
	public Box(int boxId, String name, String type) {
		super();
		this.name = name;
		this.boxId = boxId;
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBoxId() {
		return boxId;
	}


	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
