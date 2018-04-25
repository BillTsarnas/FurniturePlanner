package org.uniof.manchester.pattern.web.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.ExtraParts;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Material;
import org.uniof.manchester.pattern.web.Order;
import org.uniof.manchester.pattern.web.Piece;

public interface AccessDatabaseManager {

	public Client getClientById(Connection conn, int clientId) throws SQLException;
	
	public  int setClient(Client usuario, Connection conn) throws SQLException;
	
	public int setOrder(Order orden, boolean complete, Connection conn) throws SQLException;
	
	public  ArrayList<Integer> setInstallments(ArrayList<Installment> installments, int orderId, Connection conn) throws SQLException;
	
	public  Integer setInstallment(Installment installment, int orderId, Connection conn) throws SQLException;
	
	public ArrayList<Integer> setFurnitures(ArrayList<Furniture> furnitures, int orderId, Connection conn) throws SQLException;
	
	public Integer setFurniture(Furniture furniture, int orderId, Connection conn) throws SQLException;
	
	public void setBoxes(ArrayList<Box> boxes, int furnitureId, Connection conn) throws SQLException;
	
	public Integer setBox(Box box, int furnitureId, Connection conn) throws SQLException;
	
	public ArrayList<Integer> setPieces(ArrayList<Piece> pieces, int boxId, Connection conn) throws SQLException;
	
	public Integer setPiece(Piece piece, int boxId, Connection conn) throws SQLException;
	
	public void setMaterialRelation(int materialId, int pieceId, Connection conn) throws SQLException;
	
	public void setExtraParts(ArrayList<ExtraParts> extraparts, int boxId, Connection conn) throws SQLException;
	
	public void setExtraPartRelation(int extrapartId, int boxId, Connection conn) throws SQLException;
	
	public ArrayList<Client> getClientsByName(Connection conn, String clientName, boolean complete) throws SQLException;
	
	public int getHowManyOrdersrByClientId(Connection conn, int clientId) throws SQLException;
	
	public Order getOrderUserById(Connection conn, int clientId, boolean complete) throws SQLException;
	
	public Order getOrderByOrderId(Connection conn, int orderId, boolean complete) throws SQLException;
	
	public ArrayList<Order> getOrdersByName(Connection conn, String orderName, boolean complete) throws SQLException;
	
	public ArrayList<Installment> getInstallmentsByOrderId(Connection conn, int orderId) throws SQLException;
	
	public ArrayList<Furniture> getFurnituresByOrderId(Connection conn, int orderId, boolean complete) throws SQLException;
	
	public ArrayList<Box> getBoxesByFurnitureId(Connection conn, int furnitureId, boolean complete) throws SQLException;
	
	public ArrayList<Piece> getPiecesByBoxId(Connection conn, int boxId, boolean complete) throws SQLException;
	
	public Material getMaterialByPieceId(Connection conn, int pieceId) throws SQLException;
	
	public ArrayList<ExtraParts> getExtraPartsByBoxId(Connection conn, int boxId) throws SQLException;
	
	public ArrayList<ExtraParts> getExtraPartsByType(Connection conn, String type) throws SQLException;
	
	
	
	
}
