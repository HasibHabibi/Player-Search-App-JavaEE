<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../styles/style.css">

<title>Player App</title>
</head>
<body>

<%@include file="header.jsp" %>
<div class="registert-form" align="center">
        <h2 class="text-center">Register Team</h2>
        <form action="" method="POST" id="teamform" name="teamform">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Team Name" id="teamName" name="teamName">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Coach Name" id="coachName" name="coachName">
			</div>
			<div class="form-group">
				<button type="submit" name="registerT" id="registerT" class="btn btn-primary btn-block">Register</button>
			</div>
<!-- 			<span id="errMsg2" style="color:red;"></span> -->
		</form>
		<%if(request.getParameter("registerT") != null){%>
			<jsp:useBean id="team" class="com.model.Team" scope="session"></jsp:useBean>
			<jsp:setProperty property="*" name="team"/>
		<%
		response.sendRedirect("../registerT");
		}%>
</div>
<%}else{ %>
	<center><h1 style="color:red;"><%out.print("you cant be here");%></h1></center>
<%}%>



<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="../script/validTeam.js"></script>

</body>
</html>
