package org.uniof.manchester.pattern.web.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.ExtraParts;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Material;
import org.uniof.manchester.pattern.web.Order;
import org.uniof.manchester.pattern.web.Piece;


public class DatabaseManager implements AccessDatabaseManager {

	private final static Logger LOG = Logger.getLogger(DatabaseManager.class);

	public Client getClientById(Connection conn, int clientId) throws SQLException {

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

	protected int getMaxPieceId(Connection conn) throws SQLException {
		if(LOG.isDebugEnabled()){
			LOG.debug("getMaxPieceId");
		}

		int pieceId=0;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query ="select max(pieceid) pieceid from PIECES_PROPERTIES";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()){

				pieceId = rs.getInt("pieceid");
			}

			if(LOG.isDebugEnabled()){
				LOG.debug("getMaxPieceId" + pieceId);
			}

			return pieceId;

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				rs.close();
			} catch (Exception e) {}
		}
	}

	// Here start the setters on cascade

	public int setOrder(Order orden, boolean complete, Connection conn) throws SQLException {

		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO ORDERS (name, clientid, totalcost, status) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, orden.getName());
			ps.setInt(2, orden.getClientId());
			ps.setFloat(3, orden.getTotalcost());
			ps.setInt(4, orden.getStatus());

			ps.executeUpdate();

			int orderId = getMaxOrderId(conn); //Get the id of the order that we just inserted

			// Composite pattern objects inside more objects

			setFurnitures(orden.getFurnitures(), orderId, conn);
			setInstallments(orden.getInstallments(), orderId, conn);

			return orderId;

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}

	public  ArrayList<Integer> setInstallments(ArrayList<Installment> installments, int orderId, Connection conn) throws SQLException {

		ArrayList<Integer> idInstallments = new ArrayList<Integer>(); 

		try {

			Iterator<Installment> installmentsIterator = installments.iterator();

			while (installmentsIterator.hasNext())
			{
				Installment installment = installmentsIterator.next();
				Integer installmentId =  setInstallment(installment,orderId,conn);
				idInstallments.add(installmentId);
			}

			return idInstallments;	

		} finally {
			try {

			} catch (Exception e) {}

		}
	}

	public  Integer setInstallment(Installment installment, int orderId, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			String query ="insert into INSTALLMENTS (amount, paytype) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setDouble(1, installment.getAmount());
			ps.setString(2, installment.getPaytype());
			ps.executeUpdate(query);

			Integer installmentId = getMaxInstallmentId(conn); //Get the id of the furnitureId that we just inserted

			//Insert the relationship
			query ="INSERT INTO ORDER_INSTALLMENTS (orderid, installmentid) VALUES (?,?)";
			ps2 = conn.prepareStatement(query);
			ps2.setInt(1, orderId);
			ps2.setInt(2, installmentId);
			ps2.executeUpdate();

			return installmentId;

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				ps2.close();
			} catch (Exception e) {}
		}
	}

	public ArrayList<Integer> setFurnitures(ArrayList<Furniture> furnitures, int orderId, Connection conn) throws SQLException {

		ArrayList<Integer> ids = new ArrayList<Integer>(); 

		try {

			Iterator<Furniture> furnituresIterator = furnitures.iterator();

			while (furnituresIterator.hasNext())
			{
				Furniture furniture = furnituresIterator.next();
				Integer furnitureId =  setFurniture(furniture,orderId,conn);
				ids.add(furnitureId);
			}

			return ids;	

		} finally {
			try {

			} catch (Exception e) {}

		}
	}
	
	public Integer setFurniture(Furniture furniture, int orderId, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			String query ="INSERT INTO FURNITURE (name, type) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, furniture.getName());
			ps.setString(2, furniture.getType());
			ps.executeUpdate(query);

			Integer furnitureId = getMaxFurnitureId(conn); //Get the id of the furnitureId that we just inserted

			//Insert the relationship
			query ="INSERT INTO ORDER_FURNITURE (orderid, furnitureid) VALUES (?,?)";
			ps2 = conn.prepareStatement(query);
			ps2.setInt(1, orderId);
			ps2.setInt(2, furnitureId);
			ps2.executeUpdate();

			// Insert the boxes
			setBoxes(furniture.getBoxes(), furnitureId, conn);

			//Insert the pieces
			setPieces(furniture.getPieces(), furnitureId, conn);

			return furnitureId;

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				ps2.close();
			} catch (Exception e) {}
		}
	}

	public void setBoxes(ArrayList<Box> boxes, int furnitureId, Connection conn) throws SQLException {

		try {

			Iterator<Box> boxesIterator = boxes.iterator();

			while (boxesIterator.hasNext())
			{
				Box box = boxesIterator.next();
				setBoxRelation(box.getBoxId(),furnitureId,conn);
			}

		} finally {
			try {

			} catch (Exception e) {}

		}
	}

	public void setBoxRelation(int boxId, int furnitureId, Connection conn) throws SQLException {

		PreparedStatement ps = null;

		try {

			//Insert the relationship
			String query ="insert into FURNITURE_BOXES (furnitureid, boxid) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, boxId);
			ps.setInt(2, furnitureId);
			ps.executeUpdate();


		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}

	public ArrayList<Integer> setPieces(ArrayList<Piece> pieces, int furnitureId, Connection conn) throws SQLException {

		ArrayList<Integer> idPieces = new ArrayList<Integer>(); 

		try {

			Iterator<Piece> piecesIterator = pieces.iterator();

			while (piecesIterator.hasNext())
			{
				Piece piece = piecesIterator.next();
				setPiece(piece,furnitureId,conn);
				idPieces.add(furnitureId);
			}

			return idPieces;	


		} finally {
			try {

			} catch (Exception e) {}

		}
	}

	public Integer setPiece(Piece piece, int furnitureId, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			String query ="INSERT INTO PIECES_PROPERTIES(height,width,thickness,colour,isDoor) VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, piece.getHeight());
			ps.setInt(2, piece.getWidth());
			ps.setDouble(3, piece.getThickness());
			ps.setString(4, piece.getColour());
			ps.setBoolean(5, piece.getIsDoor());
			ps.executeUpdate(query);

			Integer pieceId = getMaxPieceId(conn); //Get the id of the furnitureId that we just inserted

			//Insert the relationship
			query ="INSERT INTO PIECES_FURNITURE(furnitureid,pieceid) (?,?)";
			ps2 = conn.prepareStatement(query);
			ps2.setInt(1, furnitureId);
			ps2.setInt(2, pieceId);
			ps2.executeUpdate();

			// Insert the materials
			setMaterialRelation(piece.getMaterial().getMaterialsId(), pieceId, conn);

			//Insert the extraparts
			setExtraParts(piece.getExtras(), pieceId, conn);

			return pieceId;

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
			try {
				ps2.close();
			} catch (Exception e) {}
		}
	}

	public void setMaterialRelation(int materialId, int pieceId, Connection conn) throws SQLException {

		PreparedStatement ps = null;

		try {

			//Insert the relationship
			String query ="insert into PIECE_MATERIAL (pieceid, materialid) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pieceId);
			ps.setInt(2, materialId);
			ps.executeUpdate();


		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}

	public void setExtraParts(ArrayList<ExtraParts> extraparts, int pieceId, Connection conn) throws SQLException {

		try {

			Iterator<ExtraParts> boxesIterator = extraparts.iterator();

			while (boxesIterator.hasNext())
			{
				ExtraParts extrapart = boxesIterator.next();
				setExtraPartRelation(extrapart.getExtraPartId(),pieceId,conn);
			}

		} finally {
			try {

			} catch (Exception e) {}

		}
	}

	public void setExtraPartRelation(int extrapartId, int pieceId, Connection conn) throws SQLException {

		PreparedStatement ps = null;

		try {

			//Insert the relationship
			String query ="insert into PIECE_EXTRAPARTS (pieceid, extrapartid) VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pieceId);
			ps.setInt(2, extrapartId);
			ps.executeUpdate();

		} finally {
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}


	// The getters in cascade start here.

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

				ArrayList<Furniture> furnitures = getFurnituresByOrderId(conn, orderId, complete);
				ArrayList<Installment> installments = getInstallmentsByOrderId(conn, orderId);
				orden = new Order( orderId, furnitures,clientId, status, installments, totalcost,name);

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
					"        i.amount " + 
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
					"       f.type" + 
					"from FURNITURE f," + 
					"(select distinct of.furnitureId furnitureId from ORDER_FURNITURE of where of.orderid=?) t" + 
					"where f.furnitureId = t.furnitureId";
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();

			while(rs.next()){

				int furnitureId = rs.getInt("furnitureId");
				String name = rs.getString("name");
				String type = rs.getString("type");

				Furniture furniture = new Furniture(name, furnitureId , type, null, null);

				if(complete)
				{
					ArrayList<Box> boxes = getBoxesByFurnitureId(conn,furnitureId);
					furniture.setBoxes(boxes);

					ArrayList<Piece> pieces = getPiecesByFurnitureId(conn,furnitureId, true);
					furniture.setPieces(pieces);
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

			String query = 	"select bc.boxId," + 
					"       bc.name," + 
					"       bc.type" + 
					"from BOXES_CATALOGUE bc," + 
					"(select distinct fb.boxId boxId from FURNITURE_BOXES fb where fb.furnitureId=?) t " + 
					"where bc.boxId = t.boxId";

			ps = conn.prepareStatement(query);
			ps.setInt(1, furnitureId);
			rs = ps.executeQuery();

			while(rs.next()){

				int boxId = rs.getInt("boxid");
				String name = rs.getString("name");
				String type = rs.getString("type");

				Box box = new Box(boxId,name, type);
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

	public ArrayList<Piece> getPiecesByFurnitureId(Connection conn, int furnitureId, boolean complete) throws SQLException {

		ArrayList<Piece> pieces = new  ArrayList<Piece>();
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			String query = 	" select pp.pieceid, " + 
					" 	     pp.height," + 
					"       pp.width," + 
					"       pp.isdoor," + 
					"       pp.thickness," + 
					"       pp.colour" + 
					"from PIECES_PROPERTIES pp," + 
					"(select distinct pf.pieceid pieceid from PIECES_FURNITURE pf where pf.furnitureId=?) t " + 
					"where pp.pieceid = t.pieceid";

			ps = conn.prepareStatement(query);
			ps.setInt(1, furnitureId);
			rs = ps.executeQuery();

			while(rs.next()){

				int pieceId = rs.getInt("pieceid");
				int height = rs.getInt("height");	
				int width = rs.getInt("width");
				boolean isDoor = rs.getBoolean("isdoor");
				int thickness = rs.getInt("thickness");
				String colour = rs.getString("colour");

				Piece piece = new Piece(pieceId,height, width, thickness, colour, isDoor,null, null);


				if(complete)
				{
					Material material =  getMaterialByPieceId(conn, pieceId);
					piece.setMaterial(material);

					ArrayList<ExtraParts> extraparts = getExtraPartsByPieceId(conn, pieceId);
					piece.setExtras(extraparts);
				}

				pieces.add(piece);

			}

			return pieces;

		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}

	public Material getMaterialByPieceId(Connection conn, int pieceId) throws SQLException {

		Material material = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			String query = 	"select mc.materialid, " + 
					"       mc.name," + 
					"       mc.cost," + 
					"       mc.colour" + 
					"from MATERIAL_CATALOGUE mc, " + 
					"(select distinct pm.materialid materialid from PIECE_MATERIAL pm where pm.pieceid=?) t " + 
					"where mc.materialid = t.materialid";

			ps = conn.prepareStatement(query);
			ps.setInt(1, pieceId);
			rs = ps.executeQuery();

			while(rs.next())
			{
				int materialId = rs.getInt("materialId");
				String name = rs.getString("name");	
				float cost = rs.getFloat("cost");
				String colour = rs.getString("colour");
				material = new Material(materialId, name, colour , cost); 
			}
			return material;

		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}

	public ArrayList<ExtraParts> getExtraPartsByPieceId(Connection conn, int pieceId) throws SQLException {

		ArrayList<ExtraParts> extraparts = new  ArrayList<ExtraParts>();
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			String query = 	" select ec.extrapartid, " + 
					"       ec.name," + 
					"       ec.cost," + 
					"       ec.type" + 
					"from EXTRAPARTS_CATALOGUE ec, " + 
					"(select distinct pe.extrapartid extrapartid from PIECE_EXTRAPARTS pe where pe.pieceid=1) t " + 
					"where ec.extrapartid = t.extrapartid";

			ps = conn.prepareStatement(query);
			ps.setInt(1, pieceId);
			rs = ps.executeQuery();

			while(rs.next()){

				int extraPartId = rs.getInt("pieceid");
				String name = rs.getString("name");
				float cost = rs.getFloat("cost");
				String type = rs.getString("type");

				ExtraParts extrapart = new ExtraParts(extraPartId,name, cost,type);
				extraparts.add(extrapart);
			}

			return extraparts;

		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				ps.close();
			} catch (Exception e) {}
		}
	}
	
	public ArrayList<ExtraParts> getExtraPartsByType(Connection conn, String type) throws SQLException {

		ArrayList<ExtraParts> extraparts = new  ArrayList<ExtraParts>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {

			String query = 	" select ec.extrapartid, " + 
					"       ec.name," + 
					"       ec.cost" + 
					"from EXTRAPARTS_CATALOGUE ec " + 
					"where ec.type = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, type.toUpperCase());
			rs = ps.executeQuery();

			while(rs.next()){

				int extraPartId = rs.getInt("pieceid");
				String name = rs.getString("name");
				float cost = rs.getFloat("cost");
		
				ExtraParts extrapart = new ExtraParts(extraPartId,name, cost,type);
				extraparts.add(extrapart);
			}

			return extraparts;

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
