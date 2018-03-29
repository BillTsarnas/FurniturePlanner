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
import org.uniof.manchester.pattern.web.Client;
import org.uniof.manchester.pattern.web.database.DatabaseManager;

/**
 * Servlet implementation class RegisterClient
 */
@WebServlet("/RegisterClient")
public class RegisterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * Log4j
	 */
	private static Logger LOG = Logger.getLogger(RegisterClient.class);
       
	
	@Resource(name="jdbc/furniture_planner")    
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterClient() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String address = (String) request.getParameter("address");
		String city = (String) request.getParameter("city");
		String postCode = (String) request.getParameter("postCode");
		String country = (String) request.getParameter("country");
		String phone = (String) request.getParameter("phone");
		String mphone = (String) request.getParameter("mphone");
		String email = (String) request.getParameter("email");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(address);
		System.out.println(city);
		System.out.println(postCode);
		System.out.println(country);
		System.out.println(phone);
		System.out.println(mphone);
		System.out.println(email);
		
		Connection conn = null;
		
		try {
				conn  = getConnection();	
				DatabaseManager dbManager = new DatabaseManager(); 
				//Client client = dbManager.getUserById(conn, 1);
				Client client = new Client(0,  firstName,  lastName,  mphone,  phone,  email,
						address+", "+city+", "+postCode+", "+country);
				
				dbManager.setUser(client, conn);
				
				request.setAttribute("user", client);
				//this.getServletContext().getRequestDispatcher("/userForm.jsp").forward(request, response);
			
			
				
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
