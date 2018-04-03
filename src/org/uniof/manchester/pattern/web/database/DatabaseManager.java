package org.uniof.manchester.pattern.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.Order;


public class DatabaseManager {
	
	public Client getUserById(Connection conn, int clientId) throws SQLException {
		
		Client user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			
			String query =null;
			query = "select userid, name, surname, mphone, hphone, email, address from USERS where userId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, clientId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				int Clientid = rs.getInt("userid");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String mphone = rs.getString("mphone");
				String hphone = rs.getString("hphone");
				String email = rs.getString("email");
				String adress = rs.getString("adress");
				
				user = new Client(Clientid,name,surname,mphone,hphone,email,adress);
			
			}
			
			return user;
	
		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
	
	public  int setUser(Client usuario, Connection conn) throws SQLException {
		
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			ResultSet rs = null;
			
		try {
			String query =null;
				query = "INSERT INTO USERS (name, surname, mphone, hphone, email, address) VALUES (?,?,?,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, usuario.getName());
				ps.setString(2, usuario.getSurname());
				ps.setString(3, usuario.getMphone());
				ps.setString(4, usuario.getHphone());
				ps.setString(5, usuario.getEmail());
				ps.setString(6, usuario.getAddress());
			
			ps.executeUpdate();	
			String query2 =null;
			query = "select max(userid) from USERS";
			ps2 = conn.prepareStatement(query2);
			rs = ps.executeQuery();

			int clientId = 0;
			
			
			while(rs.next()){
				
				clientId = rs.getInt("userid");
			}
			
			return clientId;
			
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps2.close();
			} catch (Exception e) {}
		}
	}
	
public Order getOrderUserById(Connection conn, int clientId) throws SQLException {
		
		Order orden = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
		
			String query =null;
			query = "select orderid, name, surname, totalcost, clientId, status from ORDERS where userId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, clientId);
			rs = ps.executeQuery();
			
			  
			
			while(rs.next()){
				
				int orderId = rs.getInt("orderid");
				String name = rs.getString("name");
				float totalcost = rs.getFloat("totalcost");
				clientId = rs.getInt("clientId");
				String status = rs.getString("status");
			
				orden = new Order( orderId, null,clientId, status, null, totalcost,name);
			
			}
			
			return orden;
	
		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}


public  void setOrder(Order orden, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
	String query =null;
		query = "INSERT INTO ORDERS (name, userId, totalcost, status) VALUES (?,?,?,?)";
		ps = conn.prepareStatement(query);
		ps.setString(1, orden.getName());
		ps.setInt(2, orden.getClientId());
		ps.setFloat(3, orden.getTotalcost());
		ps.setString(4, orden.getStatus());
	
	ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}

	

}
