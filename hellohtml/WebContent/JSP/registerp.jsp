<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../styles/style.css">

<title>Player App</title>
</head>
<body>
      <sql:setDataSource var = "teamMenu" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "java2"  password = "mphasis"/>
<%@include file="header.jsp" %>

<div class="registerp-form" align="center">
        <h2 class="text-center">Register Player</h2>
        <form action="" id="playerform" name="playerform">
		      <div class="form-group">
		          <input type="text" class="form-control" placeholder="Name" id="name" name="name">
		      </div>
		      <div class="form-group">
		          <input type="text" class="form-control" placeholder="Date of Birth" id="t_dob" name="t_dob">
		      </div>
		      <div class="form-group">
		          <input type="text" class="form-control" placeholder="Email" id="email" name="email">
		      </div>
		      <div class="form-group">
		          <input type="text" class="form-control" placeholder="Gender" id="gender" name="gender">
		      </div>
		      <div class="form-group">
		          <input type="text" class="form-control" placeholder="Contact" id="contact" name="contact">
		      </div>
			<div class="form-group">
				<sql:query dataSource="${teamMenu}" var="result">
           				 SELECT * from teams
        		</sql:query>
				<select class="form-control" id="teamName" name="teamName">
					<c:forEach var="row" items="${result.rows}">
						<option> <c:out value='${row.teamname}'/>
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
		          <button type="submit" name="register" id="register" class="btn btn-primary btn-block">Register</button>
		      </div>
		</form>
		
		<%if(request.getParameter("register") != null){%>
			<jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
			<jsp:setProperty property="*" name="user"/>
		<%
		response.sendRedirect("../register");
		}%>
</div>
<%}else{ %>
	<center><h1 style="color:red;"><%out.print("you cant be here");%></h1></center>
<%}%>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="../script/validPlayer.js"></script>
</body>
</html>
