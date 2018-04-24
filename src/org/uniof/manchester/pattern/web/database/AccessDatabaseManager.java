package org.uniof.manchester.pattern.web.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Order;

public interface AccessDatabaseManager {

	Client getUserById(Connection conn, int clientId) throws SQLException;
	
	int setClient(Client usuario, Connection conn) throws SQLException;
	
	void setInstallment(Installment installment, Connection conn) throws SQLException;
	
	void setOrderInstallment(int orderId, int installmentId, String payType, Connection conn) throws SQLException;
	
	Order getOrderUserById(Connection conn, int clientId, boolean complete) throws SQLException;
	
	void setOrder(Order orden, boolean complete, Connection conn) throws SQLException;
	
	void setFurnitureExtraPart(int furnitureId, int extraPartId, Connection conn) throws SQLException;
	
	void setFurnitureMaterial(int furnitureId, int materialId, Connection conn) throws SQLException;
	
	void setFurnitureBox(int furnitureId, int boxId, int sizeinsqmts, Connection conn) throws SQLException;
	
	ArrayList<Client> getClientsByName(Connection conn, String clientName, boolean complete) throws SQLException;
	
	int getHowManyOrdersrByClientId(Connection conn, int clientId) throws SQLException;
	
	ArrayList<Order> getOrdersByName(Connection conn, String orderName, boolean complete) throws SQLException;
	
	ArrayList<Installment> getInstallmentsByOrderId(Connection conn, int orderId) throws SQLException;
	
	ArrayList<Furniture> getFurnituresByOrderId(Connection conn, int orderId, boolean complete) throws SQLException;
	
	ArrayList<Box> getBoxesByFurnitureId(Connection conn, int furnitureId) throws SQLException;
	
	
	
	
	
}
