package com.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.model.User;

public class PrintUserTag extends SimpleTagSupport {

	private String[] headers;
	private List<User> userList;
	
	@Override
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<table border='1px'>");
		out.print("<tr>");
		for (String header : headers) {
			out.print("<th>"+header+"</th>");
		}
		out.print("</tr>");
		for (User user : userList) {
			out.print("<tr>");
			out.print("<td>"+user.getId()+"</td>");
			out.print("<td>"+user.getName()+"</td>");
			out.print("<td>"+user.getDob()+"</td>");
			out.print("<td>"+user.getGender()+"</td>");
			out.print("<td>"+user.getContact()+"</td>");
			out.print("<td>"+user.getEmail()+"</td>");
			out.print("<td>"+user.getTeamName()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
