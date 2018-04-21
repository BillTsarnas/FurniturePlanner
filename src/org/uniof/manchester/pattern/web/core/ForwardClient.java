package org.uniof.manchester.pattern.web.core;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import org.apache.log4j.Logger;
//import org.uniof.manchester.pattern.web.core.RegisterClient;

/**
 * Servlet implementation class ForwardClient
 */
@WebServlet("/ForwardClient")
public class ForwardClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private static Logger LOG = Logger.getLogger(RegisterClient.class);
       
	
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
		String[] parts = IdName.split(",");
		String userId = parts[0]; 
		//String firstName = request.setParameter("parts[1]");
		request.setAttribute("firstName",parts[1]);
		request.setAttribute("userId",userId);
		
		//redirect to the order page
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/order.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
