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
import org.uniof.manchester.pattern.web.database.DatabaseManager;

//import org.apache.log4j.Logger;
//import org.uniof.manchester.pattern.web.core.RegisterClient;

/**
 * Servlet implementation class ForwardClient
 */
@WebServlet("/ForwardClient")
public class ForwardClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(RegisterClient.class);
 
	
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String IdName = (String) request.getParameter("clientIdName");
		
		String clnVal = (String) request.getParameter("hid_cln_flag");  
		int cln = Integer.parseInt(clnVal);
		
		String[] parts = IdName.split(",");
		String userId = parts[0]; 
		int clientIdInt = Integer.parseInt(userId);
		//String firstName = request.setParameter("parts[1]");
		request.setAttribute("firstName",parts[1]);
		request.setAttribute("userId",userId);
		
		RequestDispatcher requestDispatcher;
		//redirect to the order page
		if (cln == 1) {
			
			Connection conn = null;
			
			try {
					conn  = getConnection();	
					DatabaseManager dbManager = new DatabaseManager(); 
			  
					//ArrayList<Client> clientList = dbManager.getClientsByName(conn, searchName, false);
					Client client = dbManager.getUserById(conn, clientIdInt);
					request.setAttribute("client",client);
					requestDispatcher = request.getRequestDispatcher("/previewClient.jsp");
			}
			catch (SQLException e)
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
		else {
	        requestDispatcher = request.getRequestDispatcher("/order.jsp");
		}
		requestDispatcher.forward(request, response);
		
	}

		private Connection getConnection() throws SQLException{
			return dataSource.getConnection();
		}
		
}
