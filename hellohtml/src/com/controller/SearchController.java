package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBO;

import com.bo.SearchBOImpl;
import com.exception.BusinessException;
import com.model.User;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private SearchBO searchBO;
	private SearchBO getSearchBO() {
		if(searchBO==null) {
			searchBO=new SearchBOImpl();
		}
		return searchBO;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ch = Integer.parseInt(request.getParameter("criteria"));
		try {
			searchBO=getSearchBO();
			String headers[] = {"User Id","Name","Dob","Gender","Contact","Email","TeamName"};
			User user;
			List<User> userList;
			switch (ch) {

			case 1:
				String id = request.getParameter("searchValue");
				// code here for BO
				user = searchBO.getUserById(id);
				if (user != null) {
					userList = new ArrayList<User>();
					userList.add(user);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("userList", userList);
					response.sendRedirect("JSP/results.jsp");
				}
				break;
				
			case 2:
				String name = request.getParameter("searchValue");
				userList = searchBO.getUserByName(name);
					if (userList!=null && userList.size()>0) {
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("userList", userList);
						response.sendRedirect("JSP/results.jsp");
					}
				break;
				
				
				
			
			case 3:
				String email = request.getParameter("searchValue");
				//code here for BO
				user = searchBO.getUserByEmail(email);
					if(user!=null) {
						userList = new ArrayList<User>();
						userList.add(user);
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("userList", userList);
						response.sendRedirect("JSP/results.jsp");
					}

				break;
			
				
				
				
			case 4:
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					Date dob = formatter.parse(request.getParameter("searchValue"));
					userList = searchBO.getUserByDOB(dob);
					if(userList!=null && userList.size()>0) {
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("userList", userList);
						response.sendRedirect("JSP/results.jsp");
						}
				break;
				
				
				
			
			case 5:
					Long contact = Long.parseLong(request.getParameter("searchValue"));
				//code here for BO
					user = searchBO.getUserByContact(contact);
					if(user!=null) {
						userList = new ArrayList<User>();
						userList.add(user);
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("userList", userList);
						response.sendRedirect("JSP/results.jsp");
					}
				break;
				
				
				
			
			case 6:
				System.out.println("Enter Gender: M/F");
				String gender = request.getParameter("searchValue");
				userList = searchBO.getUserByGender(gender.toUpperCase());
				if (userList != null && userList.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("userList", userList);
					response.sendRedirect("JSP/results.jsp");
				}
				break;

			case 7:
				String teamName = request.getParameter("searchValue2");
				// code here for BO
				userList = searchBO.getUserByTeamName(teamName);
				if (userList!= null && userList.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("userList", userList);
					response.sendRedirect("JSP/results.jsp");
				}
				break;

			default:
				throw new BusinessException("Invalid Search Criteria");

			}
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("JSP/searchp.jsp").include(request, response);
		} catch (ParseException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
	}

}
