package org.uniof.manchester.pattern.web.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Order;
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
				
				//get the Order's ID
				//String clientId = (String) request.getParameter("clientId");
				
				//create new Furniture and save it to the database
				Furniture furn = new Furniture();
				//dbManager.setFurniture(furn, conn);
				
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
