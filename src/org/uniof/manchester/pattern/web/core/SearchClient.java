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
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class SearchClient
 */
@WebServlet("/SearchClient")
public class SearchClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(RegisterClient.class);
       
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String searchName = (String) request.getParameter("searchName");
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				DatabaseManager dbManager = new DatabaseManager(); 
		  
				ArrayList<Client> clientList = dbManager.getClientsByName(conn, searchName, false);
				System.out.println("Clients:");
				Iterator<Client> crunchifyIterator = clientList.iterator();
				ArrayList<String> nameList = new ArrayList<String>();
				while (crunchifyIterator.hasNext()) {
					System.out.println(crunchifyIterator.next().getName());
					nameList.add(crunchifyIterator.next().getName()+" "+crunchifyIterator.next().getSurname());
					
				}
				request.setAttribute("nameList", nameList);
				//redirect to the order page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/printClients.jsp");
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
