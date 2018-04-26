package org.uniof.manchester.pattern.web;

import java.util.ArrayList;

public interface BoxEntity {

	public ArrayList<Piece> calculatePieces(double height, double width, double depth, double thickness, String colour, String door_colour,
			String mat, int num_shelves, int num_drawers);
	
	public ArrayList<ExtraParts> calculateExtraParts(ArrayList<ExtraParts> extrasKW, int num_drawers, int num_shelves);
	
	public String getName();

	public void setName(String name);


	public int getBoxId();

	public void setBoxId(int boxId);


	public ArrayList<Piece> getPieces();


	public void setPieces(ArrayList<Piece> pieces);


	public ArrayList<ExtraParts> getExtras();


	public void setExtras(ArrayList<ExtraParts> extras);


	public double getHeight();


	public void setHeight(double height);


	public double getWidth();


	public void setWidth(double width);


	public double getDepth();


	public void setDepth(double depth);


	public double getSizeInSqMts();


	public void setSizeInSqMts(double sizeInSqMts);


	public double getThickness();


	public void setThickness(double thickness);


	public double getBack_thickness();


	public void setBack_thickness(double back_thickness);


	public String getColour();


	public void setColour(String colour);


	public String getDoor_colour();


	public void setDoor_colour(String door_colour);
}
