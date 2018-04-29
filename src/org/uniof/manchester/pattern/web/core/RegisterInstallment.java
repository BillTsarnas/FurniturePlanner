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
import org.uniof.manchester.pattern.web.Installment;
import org.uniof.manchester.pattern.web.Order;
import org.uniof.manchester.pattern.web.database.AccessDatabaseManager;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class RegisterInstallment
 */
@WebServlet("/RegisterInstallment")
public class RegisterInstallment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static Logger LOG = Logger.getLogger(RegisterInstallment.class);
     
 	@Resource(name="jdbc/furniture_planner")    
 	private DataSource dataSource;
 	
    public RegisterInstallment() {
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
		String amount = (String) request.getParameter("amount");
		String payMethod = (String) request.getParameter("payMethod");
		String orderId = (String) request.getParameter("orderId");
		
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				AccessDatabaseManager dbManager = new DatabaseManager();
				//create new installment
				Installment installment = new Installment(0, payMethod, Double.valueOf(amount));
				System.out.println("installment amount"+ Double.valueOf(amount));
				//register the installment to th db
				int instId = dbManager.setInstallment(installment, Integer.parseInt(orderId), conn);
				System.out.println("set installment "+ instId);
				//retrieve order and client objects from db
				Order order = dbManager.getOrderByOrderId(conn, Integer.parseInt(orderId), true);
				System.out.println("client id "+ order.getClientId());
				
				System.out.println("material  "+ order.getFurnitures().get(0).getBoxes().get(0).getPieces().get(0).getMaterial().getName());
				Client client = dbManager.getClientById(conn, order.getClientId());
				System.out.println("client name "+ client.getName());
				System.out.println("installments length "+ order.getInstallments().size());
				
				//set attributes
				request.setAttribute("order", order);
				request.setAttribute("client", client);
								
				//redirect to the preview order page
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/previewOrder.jsp");
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
