package org.uniof.manchester.pattern.web.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Order;

										
public class DatabaseManager implements AccessDatabaseManager {
	
	
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
				String address = rs.getString("address");
				
				user = new Client(Clientid,name,surname,mphone,hphone,email,address);
			
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
				int status = rs.getInt("status");
			
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
		ps.setInt(4, orden.getStatus());
	
	ps.executeUpdate();
	
} finally {
	try {
		ps.close();
	} catch (Exception e) {}
}
}

/*
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
}*/


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
		String query ="INSERT INTO BOXES_FURNITURE (furnitureid , boxid, sizeinsqmts) VALUES (?,?,?)";
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


/*
public  void setBox(Box box, Connection conn) throws SQLException {
	
	PreparedStatement ps = null;
	
	/*	private String boxTypeId;
	
	private ArrayList<Piece> pieces;
	
	//unit: CM
	private int height;
	private int width;
	private int depth;
	private int sizeInSqMts; //total surface size for all the sides combined
	private double thickness = 0.16;
	private double back_thickness = 0.08;
	private String colour;
	private boolean hasDoor;
	private String door_colour;
	
	CREATE TABLE BOX_PROPERTIES
(
    boxId             		int NOT NULL,
    height 				    int NOT NULL,
    width                   int NOT NULL,
    depth                   int,
    thickness               int,
    back_thickness          double,
    colour                  varchar(255),
    num_shelves             int
);


INSERT INTO BOX_PROPERTIES(boxId,height,width,depth,thickness,back_thickness,colour,num_shelves) VALUES
(1,3, 5, 4, 1,3,'Red',2),
(1,2, 4, 4, 1,3,'Blue',2),
(1,3, 5, 4, 1,3,'Purple',2),
(2,1, 5, 4, 1,3,'Green',2),
(2,2, 1, 4, 1,3,'Red',2),
(2,3, 6, 4, 1,3,'Black',2),
(3,1, 16, 4, 1,3,'Red',2),
(3,2, 18, 4, 1,3,'Green',2),
(4,1, 24, 4, 1,3,'Purple',2),
(4,2, 12, 4, 1,3,'Red',2),
(5,1, 16, 4, 1,3,'Orange',2),
(5,2, 17, 4, 1,3,'Green',2),
(5,5, 19, 4, 1,3,'Black',2);
	
	
	
	
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
}*/

public ArrayList<Client> getClientsByName(Connection conn, String clientName, boolean complete) throws SQLException {
	
	ArrayList<Client> clients = new ArrayList<Client>();;
	ResultSet rs = null;
	CallableStatement cs = null;

	try {
	
		cs = conn.prepareCall("{call sp_get_clients_by_name(?)}");
		cs.setString(1, clientName);
		rs = cs.executeQuery();
		
		while(rs.next()){
			int clientId = rs.getInt("clientid");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String mphone = rs.getString("mphone");
			String hphone = rs.getString("hphone");
			String email = rs.getString("email");
			String address = rs.getString("address");
			
			Client cliente = new Client(clientId, name, surname, mphone, hphone, email,address); 
			clients.add(cliente);
		}
		
		return clients;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			cs.close();
		} catch (Exception e) {}
	}
}

public int getHowManyOrdersrByClientId(Connection conn, int clientId) throws SQLException {
	
	int orders = 0;
	ResultSet rs = null;
	PreparedStatement ps = null;

	try {
	
		String query =null;
		query = "select count(orderid) orders from ORDERS where clientid=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, clientId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			orders = rs.getInt("orders");
		}
		
		return orders;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			ps.close();
		} catch (Exception e) {}
	}
}

public ArrayList<Order> getOrdersByName(Connection conn, String orderName, boolean complete) throws SQLException {
	
	ArrayList<Order> orders = new ArrayList<Order>();
	ResultSet rs = null;
	CallableStatement cs = null;

	try {
	
		cs = conn.prepareCall("{call sp_get_orders_by_name(?)}");
		cs.setString(1, orderName );
		rs = cs.executeQuery();
		
		while(rs.next()){
			int orderId = rs.getInt("orderid");
			int clientId = rs.getInt("clientid");
			String name = rs.getString("name");
			float totalcost = rs.getFloat("totalcost");
			int status = rs.getInt("status");
			
			
			Order order = new Order(orderId, null, clientId, status, null, totalcost,name); 
					
			if(complete)
			{
				
				ArrayList<Furniture> furnitures = getFurnituresByOrderId(conn, orderId, complete);
				order.setFurnitures(furnitures);
				
				ArrayList<Installment> installments = getInstallmentsByOrderId(conn, orderId);
				order.setInstallments(installments);
				
			}
			orders.add(order);

		}
		
		return orders;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			cs.close();
		} catch (Exception e) {}
	}
}

public ArrayList<Installment> getInstallmentsByOrderId(Connection conn, int orderId) throws SQLException {
	
	ArrayList<Installment> installments = new  ArrayList<Installment>();
	ResultSet rs = null;
	PreparedStatement ps = null;

	try {
	
		String query = 	" select i.installmentid," + 
						"        t.paytype, " + 
						"       i.amount " + 
						"from INSTALLMENTS i,  " + 
						"(select distinct io.installmentid installmentid, paytype from ORDER_INSTALLMENTS io where io.orderid=1) t " + 
						"where i.installmentid = t.furnitureId";
		
		ps = conn.prepareStatement(query);
		ps.setInt(1, orderId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			int installmentId = rs.getInt("installmentID");
			String paytype = rs.getString("paytype");
			double amount = rs.getDouble("amount");
			
			Installment installment = new Installment(installmentId, paytype, amount);
			installments.add(installment);
		}
		
		return installments;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			ps.close();
		} catch (Exception e) {}
	}
}

public ArrayList<Furniture> getFurnituresByOrderId(Connection conn, int orderId, boolean complete) throws SQLException {
	
	ArrayList<Furniture> furnitures = new  ArrayList<Furniture>();
	ResultSet rs = null;
	PreparedStatement ps = null;

	try {
	
		String query = "select f.furnitureid," + 
					   "       f.name," + 
					   "       f.numofcuts" + 
					   "from FURNITURE f," + 
					   "(select distinct of.furnitureId furnitureId from ORDER_FURNITURE of where of.orderid=?) t" + 
					   "where f.furnitureId = t.furnitureId";
		ps = conn.prepareStatement(query);
		ps.setInt(1, orderId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			int furnitureId = rs.getInt("furnitureId");
			String name = rs.getString("name");
			int numOfCuts = rs.getInt("numofcuts");
			
			Furniture furniture = new Furniture(name, furnitureId, numOfCuts , null);
	
			if(complete)
			{
				ArrayList<Box> boxes = getBoxesByFurnitureId(conn,furnitureId);
				furniture.setBoxes(boxes);
			}	
			
			furnitures.add(furniture);
		}
		
		return furnitures;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			ps.close();
		} catch (Exception e) {}
	}
}

public ArrayList<Box> getBoxesByFurnitureId(Connection conn, int furnitureId) throws SQLException {
	
	ArrayList<Box> boxes = new  ArrayList<Box>();
	ResultSet rs = null;
	PreparedStatement ps = null;

	try {
	
		String query = "select bc.boxid," + 
						"       bc.name," + 
						"       bp.height," + 
						"       bp.width," + 
						"       bp.depth," + 
						"       bp.thickness," + 
						"       bp.colour" + 
						"from BOXES_CATALOGUE bc, " + 
						"	 BOX_PROPERTIES bp," + 
						"     (select distinct bf.boxId boxId from BOXES_FURNITURE bf where bf.furnitureId=1) t " + 
						"where bc.boxId = t.boxId" + 
						"and bc.boxid = bp.boxid";
		
		ps = conn.prepareStatement(query);
		ps.setInt(1, furnitureId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			int boxId = rs.getInt("boxid");
			String name = rs.getString("name");
			int height = rs.getInt("height");
			int width = rs.getInt("width");
			int depth = rs.getInt("depth");
			int thickness = rs.getInt("thickness");
			String colour = rs.getString("colour");
			
			Box box = new Box(boxId,name,  height, width , depth, thickness,colour);
			boxes.add(box);
		}
		
		return boxes;

	} finally {
		try {
			rs.close();
		} catch (Exception e) {}
		try {
			ps.close();
		} catch (Exception e) {}
	}
}


}
