package org.uniof.manchester.pattern.web.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.ExtraParts;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Materials;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class RegisterKitchen
 */
@WebServlet("/RegisterKitchen")
public class RegisterKitchen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger LOG = Logger.getLogger(RegisterClient.class);
    
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
       
    
    public RegisterKitchen() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				DatabaseManager dbManager = new DatabaseManager(); 
				
				//Add a new temporary material. A set of materials should be stored in the database
				ArrayList<Materials> mats = new ArrayList<Materials>();
				Materials mat = new Materials(0,"melamine", "black", 5);
				mats.add(mat);
				
				//Add a new temporary extra part. A set of extra parts should be stored in the database
				ArrayList<ExtraParts> exts = new ArrayList<ExtraParts>();
				ExtraParts ext = new ExtraParts(0,"wheel",1f);
				exts.add(ext);
				
				//firstly get the number of boxes
				Integer num_boxes = Integer.valueOf(request.getParameter("num_boxes"));
				
				//create a list of Boxes
				ArrayList<Box> boxes = new ArrayList<Box>();
				
				for(int i=1; i<=num_boxes; i++) {
					
					//Create a new Box with default thickness 16
					String box_name = (String) request.getParameter("box_name"+i);
					Integer box_height = Integer.valueOf(request.getParameter("box_height"+i));
					Integer box_width = Integer.valueOf(request.getParameter("box_width"+i));
					Integer box_depth = Integer.valueOf(request.getParameter("box_depth"+i));
					Integer box_num_shelves = Integer.valueOf(request.getParameter("box_num_shelves"+i));
					String box_colour = (String) request.getParameter("box_colour"+i);
					
					Box box = new Box(box_name,box_height, box_width, box_depth, 16, box_colour, box_num_shelves);
					boxes.add(box);
				}
				
				//create new Furniture and save it to the database
				Furniture furn = new Furniture(0, boxes,exts,mats);
				dbManager.setFurniture(furn, conn);
				
				//redirect to the order page
				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/order.jsp");
				//requestDispatcher.forward(request, response);
			
			
				
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
