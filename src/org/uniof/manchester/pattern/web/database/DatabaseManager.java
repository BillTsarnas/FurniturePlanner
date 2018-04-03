package org.uniof.manchester.pattern.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.uniof.manchester.pattern.web.Client;


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
	
	public  void setUser(Client usuario, Connection conn) throws SQLException {
		
			PreparedStatement ps = null;
			
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
			
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
	

}
