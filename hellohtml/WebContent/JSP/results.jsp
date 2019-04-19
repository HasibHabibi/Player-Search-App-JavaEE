<%@page import="com.model.User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="st" uri="../WEB-INF/usertags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results Page</title>
</head>
<body>
	<h1 align="center">Your Search Results will be here</h1>
	<br />
	<br />
	<%
		if (session != null && session.getAttribute("userList") != null) {
			String headers[] = (String[]) session.getAttribute("headers");
			List<User> userList = (List<User>) session.getAttribute("userList");
	%>
	<st:userResults userList="<%=userList%>" headers="<%=headers%>" />
	<%} %>
</body>
</html>