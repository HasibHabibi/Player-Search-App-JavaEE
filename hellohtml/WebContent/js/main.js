var message = "";
function isValidUserCredentials() {
	var id = document.getElementById("id").value;
	var password = document.getElementById("password").value;
	var b = false;
	
	if(id=="" || password=="") {
		message="id and password is required";
	} else {
		message = "";
		b=true;
	}
	if(b==true) {
		b= isValidid(id);
		if(b==true) {
			b = isValidPassword(password);
		}
	}
	document.getElementById("errMsg").innerText=message;
	return b;
}

function isValidid(id) {
	var b1= false;
	if(id.match(/^[a-zA-Z0-9]{10}$/)) {
		b1=true;
	} else {
		message = "Invalid id/Password";
	}
	return b1;
}

function isValidPassword(password) {
	var b2 = false;
	if(password.match(/^[a-zA-Z0-9]{3}@[0-9]{3}$/)) {
		b2=true;
	}else {
		message = "Invalid Password";
	}
	return b2;
}