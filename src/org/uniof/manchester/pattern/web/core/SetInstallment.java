package org.uniof.manchester.pattern.web.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.database.AccessDatabaseManager;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class SetInstallment
 */
@WebServlet("/SetInstallment")
public class SetInstallment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static Logger LOG = Logger.getLogger(SetInstallment.class);
    
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    public SetInstallment() {
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
		
		String numInstallments = (String) request.getParameter("num_instal");

		
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				AccessDatabaseManager dbManager = new DatabaseManager();
				//Client client = dbManager.getUserById(conn, 1);
				//Client client = new Client(0,  firstName,  lastName,  mphone,  phone,  email,
				//		address+", "+city+", "+postCode+", "+country);
				
				//dbManager.setClient(client, conn);
				
				//int userId = dbManager.setClient(client, conn);
				//System.out.println("Client '"+ userId +"' saved");
				
				//get the newclient's ID?
				//request.setAttribute("userId",userId);
				
				//redirect to the order page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/installments.jsp");
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
