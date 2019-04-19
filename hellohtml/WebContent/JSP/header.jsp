<%
	if(session != null && session.getAttribute("playerid") != null) {
%>
<h1>Welcome <%=session.getAttribute("playerid") %></h1>

<center><h1>Player/Team Database</h1></center>
<div class="topnav" id="myTopnav">
  <a href="../logout">Logout</a>
  <a href="searchp.jsp">Search Player</a>
  <a href="registerp.jsp">Register Player</a>
  <a href="registert.jsp">Register Team</a>
  <a href="updatep.jsp">Update Player</a>
  <a href="deletep.jsp">Delete Player</a>
</div>