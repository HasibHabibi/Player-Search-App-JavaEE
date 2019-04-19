<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
		if (session != null && session.getAttribute("playerid") != null) {
	%>
	<h1>
		Welcome <%=session.getAttribute("playerid")%></h1>
	<h2>
		Logged in successfully at
		<%=new Date()%></h2>
	<a href="../logout">LogOFF</a><br>
	<a href="searchp.jsp">Home</a>
	<%} else {%>
	<h2 align="center" style="color: red;">Please Login first</h2>
	<%
		}
	%>
</body>
</html>