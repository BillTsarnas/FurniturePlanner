package org.uniof.manchester.pattern.web.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.util.Iterator;
import org.apache.log4j.Logger;
import org.uniof.manchester.pattern.web.Order;
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.Furniture;
import org.uniof.manchester.pattern.web.Box;
import org.uniof.manchester.pattern.web.database.AccessDatabaseManager;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

//import org.apache.log4j.Logger;
//import org.uniof.manchester.pattern.web.core.RegisterClient;

/**
 * Servlet implementation class ForwardClient
 */
@WebServlet("/ForwardOrder")
public class ForwardOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(RegisterClient.class);
 
	
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardOrder() {
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
		String IdName = (String) request.getParameter("orderIdName");
		
		String ordVal = (String) request.getParameter("hid_ord_flag");  
		int ord = Integer.parseInt(ordVal);
		
		String[] parts = IdName.split(",");
		String userId = parts[0]; 
		int orderIdInt = Integer.parseInt(userId);
		//String firstName = request.setParameter("parts[1]");
		//request.setAttribute("firstName",parts[1]);
		//request.setAttribute("userId",userId);
		
		RequestDispatcher requestDispatcher;
		//redirect to the order page
		if (ord == 2) {
			
			Connection conn = null;
			
			try {
					conn  = getConnection();
					
					AccessDatabaseManager dbManager = new DatabaseManager();
				
					Order order = dbManager.getOrderByOrderId(conn, orderIdInt, true);
					System.out.println("Phra order"+order.getClientId());
					
					Client client = dbManager.getClientById(conn, order.getClientId());
					System.out.println("Phra order"+order.getClientId());
					   
					request.setAttribute("client",client);
					request.setAttribute("order",order);
					requestDispatcher = request.getRequestDispatcher("/previewOrder.jsp");
					//requestDispatcher.forward(request, response);
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
