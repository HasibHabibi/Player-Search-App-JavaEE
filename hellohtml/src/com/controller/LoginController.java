package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.LoginBOImpl;
import com.exception.BusinessException;
import com.model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		RequestDispatcher rd = null;
		try {
			if(new LoginBOImpl().isValidUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("playerid",user.getId());
				response.sendRedirect("JSP/success.jsp");
			}
		} catch (BusinessException e) {
			rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("errorMessage", e.getMessage());
			rd.include(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setId(request.getParameter("playerid"));
		user.setPassword(request.getParameter("password"));
		RequestDispatcher rd = null;
		try {
			if(new LoginBOImpl().registerUser(user) != null) {
				HttpSession session = request.getSession();
				session.setAttribute("playerid",user.getId());
				session.invalidate();
				out.println("<center><h2>Registration was successful"
						+ "</br>Redirecting to Home page...</h2></center>");
				response.setHeader("refresh", "3;url='/hellohtml'");
			}
		} catch (BusinessException e) {
			rd=request.getRequestDispatcher("index.jsp");
			String s=e.getMessage();
			if(s.contains("SQLIntegrityConstraintViolationException")) {
				s = "Not an Active User in Database";
			}
			request.setAttribute("errorMessage", s);
			rd.include(request, response);
		}
		
	}
	
	

}
