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
      <sql:setDataSource var = "updateMenu" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "java2"  password = "mphasis"/>
<%@include file="header.jsp" %>
<div class="updatep-form" align="center">
		<h2 class="text-center">Update Player Contact</h2>
		<form action="../update" id="updateform" method="POST" id="updateform" name="updateform">
			<div class="form-group">
				<sql:query dataSource="${updateMenu}" var="result">
           				 SELECT * from player
        		</sql:query>
				<select class="form-control" id="playerid" name="playerid">
					<c:forEach var="row" items="${result.rows}">
						<option>
							<c:out value='${row.id}' />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Enter New Contact" id="contact" name="contact" >
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Update</button>
			</div>
		</form>
	</div>
<%}else{ %>
	<center><h1 style="color:red;"><%out.print("you cant be here");%></h1></center>
<%}%>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="../script/update.js"></script>
</body>
</html>
