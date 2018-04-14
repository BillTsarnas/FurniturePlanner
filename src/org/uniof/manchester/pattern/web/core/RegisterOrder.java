package org.uniof.manchester.pattern.web.core;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

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
		System.out.println("Ta daaaaaaa");
		
		
	}

}
