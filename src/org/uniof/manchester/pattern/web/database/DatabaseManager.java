package org.uniof.manchester.pattern.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.ExtraParts;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Materials;
import org.uniof.manchester.pattern.web.Order;


public class DatabaseManager {
	
	
	private final static Logger LOG = Logger.getLogger(DatabaseManager.class);
	
	public Client getUserById(Connection conn, int clientId) throws SQLException {
		
		Client user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			
			String query =null;
			query = "select clientid, name, surname, mphone, hphone, email, address from CLIENTS where clientid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, clientId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				int Clientid = rs.getInt("clientid");
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
	
	public  int setClient(Client usuario, Connection conn) throws SQLException {
		
			PreparedStatement ps = null;
			
		try {

			String query =null;
				query = "INSERT INTO CLIENTS (name, surname, mphone, hphone, email, address) VALUES (?,?,?,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, usuario.getName());
				ps.setString(2, usuario.getSurname());
				ps.setString(3, usuario.getMphone());
				ps.setString(4, usuario.getHphone());
				ps.setString(5, usuario.getEmail());
				ps.setString(6, usuario.getAddress());
			
			ps.executeUpdate();	
		
			return getMaxClientId(conn);
			
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
	
	
    protected int getMaxClientId(Connection conn) throws SQLException {
        if(LOG.isDebugEnabled()){
            LOG.debug("getMaxClientId");
        }
        
        int clientId=0;
        PreparedStatement ps = null;
		ResultSet rs = null;
       
		try {
		
        String query ="select max(clientid) clientid from CLIENTS";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
        
		while(rs.next()){
			
			clientId = rs.getInt("clientid");
		}
		
	    if(LOG.isDebugEnabled()){
	    LOG.debug("getMaxClientId" + clientId);
	    }
		
		return clientId;
		
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
    }
    
    protected int getMaxOrderId(Connection conn) throws SQLException {
        if(LOG.isDebugEnabled()){
            LOG.debug("getMaxOrderId");
        }
        
        int orderId=0;
        PreparedStatement ps = null;
		ResultSet rs = null;
       
		try {
		
        String query ="select max(orderid) orderid from ORDERS";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
        
		while(rs.next()){
			
			orderId = rs.getInt("orderid");
		}
		
	    if(LOG.isDebugEnabled()){
	    LOG.debug("getMaxOrderId" + orderId);
	    }
		
		return orderId;
		
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
    }
    
    protected int getMaxInstallmentId(Connection conn) throws SQLException {
        if(LOG.isDebugEnabled()){
            LOG.debug("getMaxInstallmentId");
        }
        
        int installmentId=0;
        PreparedStatement ps = null;
		ResultSet rs = null;
       
		try {
		
        String query ="select max(installmentid) installmentid from INSTALLMENTS";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
        
		while(rs.next()){
			
			installmentId = rs.getInt("installmentid");
		}
		
	    if(LOG.isDebugEnabled()){
	    LOG.debug("getMaxInstallmentId" + installmentId);
	    }
		
		return installmentId;
		
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
    }
    
    protected int getMaxFurnitureId(Connection conn) throws SQLException {
        if(LOG.isDebugEnabled()){
            LOG.debug("getMaxFurnitureId");
        }
        
        int furnitureId=0;
        PreparedStatement ps = null;
		ResultSet rs = null;
       
		try {
		
        String query ="select max(furnitureid) furnitureid from FURNITURE";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
        
		while(rs.next()){
			
			furnitureId = rs.getInt("furnitureid");
		}
		
	    if(LOG.isDebugEnabled()){
	    LOG.debug("getMaxFurnitureId" + furnitureId);
	    }
		
		return furnitureId;
		
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
    }
    
    protected int getMaxBoxId(Connection conn) throws SQLException {
        if(LOG.isDebugEnabled()){
            LOG.debug("getMaxBoxId");
        }
        
        int boxId=0;
        PreparedStatement ps = null;
		ResultSet rs = null;
       
		try {
		
        String query ="select max(boxid) boxid from BOX";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
        
		while(rs.next()){
			
			boxId = rs.getInt("boxid");
		}
		
	    if(LOG.isDebugEnabled()){
	    LOG.debug("getMaxBoxId" + boxId);
	    }
		
		return boxId;
		
		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
    }
	
    public  void setInstallment(Installment installment, Connection conn) throws SQLException {
    	
    	PreparedStatement ps = null;
    	
    try {
    		String query ="INSERT INTO INSTALLMENTS (amount) VALUES (?)";
    		ps = conn.prepareStatement(query);
    		ps.setDouble(1, installment.getAmount());
    	
    	ps.executeUpdate();
    	
    } finally {
    	try {
    		ps.close();
    	} catch (Exception e) {}
    }
    }
    
    public  void setOrderInstallment(int orderId, int installmentId, String payType, Connection conn) throws SQLException {
    	
    	PreparedStatement ps = null;
    	
    try {
    		String query ="INSERT INTO ORDER_INSTALLMENTS (orderid, installmentid, paytype) VALUES (?,?,?)";
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, orderId);
    		ps.setInt(2, installmentId);
    		ps.setString(3, payType);
    	
    	ps.executeUpdate();
    	
    } finally {
    	try {
    		ps.close();
    	} catch (Exception e) {}
    }
    }
    
    
    
public Order getOrderUserById(Connection conn, int clientId, boolean complete) throws SQLException {
		
		Order orden = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
		
			String query =null;
			query = "select orderid, name, surname, totalcost, clientId, status from ORDERS where clientid=?";
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


public  void setOrder(Order orden, boolean complete, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
	String query =null;
		query = "INSERT INTO ORDERS (name, clientid, totalcost, status) VALUES (?,?,?,?)";
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


public  void setFurniture(Furniture furniture, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
		String query ="INSERT INTO FURNITURE (numofextraParts,numofcuts) VALUES (?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, furniture.getNumextraParts());
		ps.setInt(2, furniture.getNumOfCuts());
		ps.executeUpdate();
	
		int furnitureId = getMaxFurnitureId(conn);
		Iterator<ExtraParts> extraPartsIt = furniture.getExtraparts().iterator();
		
		while(extraPartsIt.hasNext())
		{
			ExtraParts extrapart = (ExtraParts)extraPartsIt.next();
			setFurnitureExtraPart(furnitureId, extrapart.getExtraPartId(), conn);
		}	
				
		Iterator<Materials> materialsIt = furniture.getMaterials().iterator();
		
		while(materialsIt.hasNext())
		{
			Materials materials = (Materials)materialsIt.next();
			setFurnitureExtraPart(furnitureId, materials.getMaterialsId(), conn);
		}	
		
		Iterator<Box> boxIt = furniture.getBoxes().iterator();
		
		while(boxIt.hasNext())
		{
			Box box = (Box)boxIt.next();
			setBox(box,conn);
			setFurnitureBox(furnitureId, getMaxBoxId(conn), box.getSizeInSqMts(), conn);
		}	
		
		
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}


public  void setFurnitureExtraPart(int furnitureId, int extraPartId, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
		String query ="INSERT INTO FURNITURE_EXTRAPARTS (furnitureid , extrapartid) VALUES (?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, furnitureId);
		ps.setInt(2, extraPartId);
		ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}

public  void setFurnitureMaterial(int furnitureId, int materialId, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
		String query ="INSERT INTO FURNITURE_MATERIAL (furnitureid , materialid) VALUES (?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, furnitureId);
		ps.setInt(2, materialId);
		ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}

public  void setFurnitureBox(int furnitureId, int boxId, int sizeinsqmts, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
		String query ="INSERT INTO BOXES_FURNITURE (furnitureid , boxid, sizqinsqmts) VALUES (?,?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, furnitureId);
		ps.setInt(2, boxId);
		ps.setInt(3, sizeinsqmts);
		ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}



public  void setBox(Box box, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
try {
		String query ="INSERT INTO BOX (thickness, back_thickness, colour, num_shelves,height,width,depth) VALUES (?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, box.getThickness());
		ps.setDouble(2,box.getBack_thickness());
		ps.setString(3,box.getColour());
		ps.setInt(4,box.getNum_shelves());
		ps.setInt(5,box.getHeight());
		ps.setInt(6,box.getWidth());
		ps.setInt(7,box.getDepth());
	
	ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}




}
