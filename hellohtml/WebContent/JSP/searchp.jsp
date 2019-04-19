<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<link rel="stylesheet" href="../styles/style.css">

<title>Player App</title>
</head>
<body>
      <sql:setDataSource var = "teamMenu" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "java2"  password = "mphasis"/>
         
	<%@include file="header.jsp"%>

	<h2 class="text-center">Search Player</h2>
	<div class="searchp-form" align="center">

		<form action="../search">
		<div align="center">

			<select id ="criteria" name="criteria" onclick="toggle()">
				<option value="0">Select</option>
				<option value="1">By Player ID</option>
				<option value="2">By Name</option>
				<option value="3">By Email</option>
				<option value="4">By DOB</option>
				<option value="5">By Contact</option>
				<option value="6">By Gender</option>
				<option value="7">By TeamName</option>
			</select></div>
			<div id="in" style="display: none;">
				<!-- <input type="text" name="searchValue"> -->
				<sql:query dataSource="${teamMenu}" var="result"> SELECT * from teams
	        		</sql:query>
				<select class="form-control" id="teamName" name="searchValue2">
					<c:forEach var="row" items="${result.rows}">
						<option>
							<c:out value='${row.teamname}' />
						</option>
					</c:forEach>
				</select>

			</div><br/>
			<div id="in2" style="display: none;">
				<input type="text" name="searchValue">
			</div>
			<input type="submit" value="Search">
			<%
				if (request.getAttribute("errorMessage") != null) {
			%>
			<span style="color: red;"><%=request.getAttribute("errorMessage")%></span>
			<%
				request.removeAttribute("errorMessage");
					}
			%>
		</form>

<script type="text/javascript">
function toggle() {
	var e = document.getElementById("criteria").value;
	var query = document.getElementById("in");
	var j = document.getElementById("in2");
	if(e =='7') {
		query.style.display = "block";
		j.style.display = "none"
	}
	else {
		query.style.display = "none";
		j.style.display = "block";
	}
	
}
</script>
	</div>
	<%}else{ %>
	<center><h1 class ="warning" style="color:red;"><%out.print("you cant be here");%></h1></center>
<%}%>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="../script/searchPlayer.js"></script>

</body>
</html>
