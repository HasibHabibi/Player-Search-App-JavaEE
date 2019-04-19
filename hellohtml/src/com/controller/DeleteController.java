package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBOImpl;
import com.exception.BusinessException;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("playerid");
		HttpSession session = request.getSession();
		try {
			if(new SearchBOImpl().deleteUser(id)) {
				session.setAttribute("playerid", id);
			}
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
		response.sendRedirect("JSP/deleted.jsp");	

		
	}

}
