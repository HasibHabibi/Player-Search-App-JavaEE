<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session != null && session.getAttribute("playerid") != null && session.getAttribute("contact") != null) {
	%>
	<h2>
		Player's contact with ID: <%=session.getAttribute("playerid")%> successfully updated at
		<%=new Date()%> with new contact: <%=session.getAttribute("contact")%></h2>
	<a href="../logout">LogOFF</a><br>
	<a href="searchp.jsp">Home</a>
	<%} else {%>
	<h2 align="center" style="color: red;">ERROR: <%=session.getAttribute("errorMessage")%></h2>
	<%
		}
	%>
</body>
</html>