package org.uniof.manchester.pattern.web.core;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.BoxEntity;
import org.uniof.manchester.pattern.web.BoxFactory;
import org.uniof.manchester.pattern.web.ExtraParts;
import org.uniof.manchester.pattern.web.Material;
import org.uniof.manchester.pattern.web.Order;
import org.uniof.manchester.pattern.web.Piece;
import org.uniof.manchester.pattern.web.database.AccessDatabaseManager;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class RegisterOrder
 */
@WebServlet("/RegisterOrder")
public class RegisterOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger LOG = Logger.getLogger(RegisterClient.class);
       
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    public RegisterOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				AccessDatabaseManager dbManager = new DatabaseManager();
				
				//create a stub box, testing purposes
				
				ArrayList<String> kind = new ArrayList<String>();
				ArrayList<String> names = new ArrayList<String>();
				
				/*for (int k=0; k<10; k++) {
					ExtraParts ext = new ExtraParts(0,"tmp_extrapart", 2.68f, "K");
					extrasK.add(ext);
				}
				
				Material mater = new Material(0, "some_material", "skata", 1.5f);
				
				//create a new instance of the Helper creation class
				System.out.println("prin factory");
				BoxFactory factory = new BoxFactory();
				System.out.println("meta factory");
				
				String boxType = "Box with 4 shelves and a set of 4 drawers";
				double height = 72.0;
				double width = 60.0;
				double depth = 56.0;
				double thickness = 1.6;
				String colour = "wood";
				String door_colour = "red";
				String mat = "oksia";
				String FurType = "W";
				
				System.out.println("prin");
				BoxEntity box = factory.createBox(boxType, height, width, depth, thickness, colour, door_colour, extrasK, mat, FurType);
				System.out.println("meta");
				//Box box = factory.createBoxShelfDrawers(1,"testbox",72.0, 60.0, 56.0, 1.6, "skata", "kafe" ,extrasK,mater, 1,4);
				
				System.out.println(box.getName());
				System.out.println("getName");
				ArrayList<Piece> pcs = box.getPieces();
				Iterator<Piece> crunchifyIterator = pcs.iterator();
				
            	while (crunchifyIterator.hasNext()) {
            		Piece curr = crunchifyIterator.next();
            		System.out.println(curr.getHeight());
            		System.out.println(curr.getWidth());
            		System.out.println(curr.getThickness());
            		System.out.println("--end of piece--");
            	}
            	System.out.println(pcs.size());
				*/
				//get the client's ID
				String clientId = (String) request.getParameter("clientId");
				
				//get Order's name
				String order_name = (String) request.getParameter("order_name");
				String num_furn = (String) request.getParameter("num_furniture");
				int num_fur = Integer.parseInt(num_furn);
				
				//get Order's status: 0 for Active, 1 for offer, 2 for on progress, 3 for declined
				int status_code =-1;
				String order_status = (String) request.getParameter("order_status");
				if (order_status.equals("Active")) status_code = 0;
				else if (order_status.equals("Offer")) status_code = 1;
				else if (order_status.equals("On Progress")) status_code = 2;
				else if (order_status.equals("Declined")) status_code = 3;
				
				for (int i=0; i<num_fur; i++) {
					
					String fur_kind = (String) request.getParameter("fur_kind"+(i+1));
					String fur_name = (String) request.getParameter("fur_name"+(i+1));
					
					kind.add(fur_kind);
					names.add(fur_name);
					System.out.println("add"+i);
				}
				
				//create new Order and save it to the database
				//stub order
				request.setAttribute("fur_kinds", kind);
				request.setAttribute("fur_names", names);
				
				//Order order = new Order(0, null, Integer.valueOf(clientId), status_code, null, 0, order_name );
				//System.out.println("before set1");
				request.setAttribute("order_name", order_name);
				//System.out.println("before set2");
				request.setAttribute("clientId", clientId);
				//System.out.println("before set3");
				request.setAttribute("status_code", status_code);
				//System.out.println("before set4");
				request.setAttribute("num_furniture", num_fur);
				//System.out.println("end");
				
				//dbManager.setOrder(order, false, conn);
				//System.out.println("set order");
				//request.setAttribute("order", order);
				//System.out.println("setAttribute");
				
				//redirect to the order page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderEditing.jsp");
				requestDispatcher.forward(request, response);
			
		}catch (SQLException e)
		{
			LOG.error("Problemas en la generaci�n del excel de calificaciones desde SQL " +  e);
			throw new RuntimeException("SQL error : " + e.getMessage());
		} catch (Exception e) {
			LOG.fatal("Excepci�n al generar el reporte : " + e.getMessage());
			throw new RuntimeException("Excepci�n al generar el reporte : " + e.getMessage());
		}
		finally 
		{
			try 
			{	if(conn!=null){conn.close();}	
			} catch (SQLException e) 
			{
				LOG.error("Problemas al cerrar la conexi�n despues de crear el excel de calificaciones,", e);
				throw new ServletException(e.getMessage(), e);
			}
	   }
		
		
	}
	
	private Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}
