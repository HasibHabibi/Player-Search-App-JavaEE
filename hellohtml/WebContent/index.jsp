<!DOCTYPE html>
<html lang="en">
<head>
	<title>Database Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-70">
						Welcome to DB
					</span>
					<span class="login100-form-avatar">
						<img src="images/avatar-01.jpg" alt="AVATAR">
					</span>
				</form>
				<form action="login" method="get"
					onsubmit="return isValidUserCredentials()">
					<!-- onsubmit="return isValidUserCredentials()" -->
					<div class="wrap-input100 validate-input m-t-85 m-b-35">
						<input class="input100" type="text" name="id" id="id"> <span
							class="focus-input100" data-placeholder="Id"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-50">
						<input class="input100" type="password" name="password"
							id="password"> <span class="focus-input100"
							data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn m-b-25">Login</button>
						<button class="login100-form-btn" type="reset">Cancel</button>
					</div>
				</form>
				<%
					if (request.getAttribute("errorMessage") != null) {
				%>
				<span style="color: red;"><%=request.getAttribute("errorMessage")%></span>
				<%
					request.removeAttribute("errorMessage");
					}
				%>
				<form>
					<ul class="login-more p-t-190">
						<li><span class="txt1"> Don't have an account? </span> <a
							href="JSP/registration.jsp" class="txt2"> Sign up </a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>


<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
