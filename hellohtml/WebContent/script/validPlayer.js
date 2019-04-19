/*var message = "";
function isValidPlayerCredentials() {
	var name = document.getElementById("name").value;
	var dob = document.getElementById("dob").value;
	var email = document.getElementById("email").value;
	var gender = document.getElementById("gender").value;
	var contact = document.getElementById("contact").value;
	var teamName = document.getElementById("teamName").value;
	var b = false;
	
	if(name=="" || dob=="" ||email=="" || gender=="" ||contact=="" || teamName=="") {
		message="All information is required";
	} else{
		message = "";
		b = true;
	}
	if(b==true) {
		b = (isValidName(name)
		&& isValidEmail(email)
		&& isValidGender(gender)
		&& isValidContact(contact));
	}
	
	document.getElementById("errMsg").innerText=message;
	return b;
}

function isValidName(name) {
	var b1 = false;
	if(message.length==0 && name.match(/^[a-zA-Z]{2,20}$/)) {
		b1=true;
	} else {
		message = "Invalid name";
	}
	console.log("Name = " + b1);
	return b1;
}

function isValidEmail(email) {
	var b2 = false;
	if(email.match(/^(.+)@(.+)$/)) {
		b2 = true;
	} else {
		message = "Invalid email";
	}
	
	console.log("Email = " + b2);
	return b2;
}

function isValidGender(gender) {
	var b3 = false;
	if(gender.match(/^[mfMF]{1}$/)) {
		b3 = true;
	} else {
		message = "Invalid gender";
	}
	
	console.log("Gender = " + b3);
	return b3;
}

function isValidContact(contact) {
	var b4 = false;
	if(contact.match(/^[0-9]{10}$/)) {
		b4 = true;
	} else {
		message = "Invalid contact";
	}
	
	console.log("Contact = " + b4);
	return b4;
}*/



$(function() {
	
	$.validator.addMethod("genderFormat",
		    function(value, element) {
		        return value.match(/^[mfMF]{1}$/);
		    },
		    "Please enter a gender with (m/f)");
	
	$.validator.addMethod("nameFormat",
		    function(value, element) {
		        return value.match(/^[a-zA-Z ]{2,20}$/);
		    },
		    "Please enter a name with only letters & more than one character");
	
	$.validator.addMethod("dateFormat",
		    function(value, element) {
		        return value.match(/^[0-9]{2}-[0-9]{2}-[0-9]{4}$/);
		    },
		    "Please enter date as dd-MM-yyyy");
	
	$('#playerform').validate({
		rules: {
			name: {
				required: true,
				nameFormat: true
			},
			t_dob: {
				required: true,
				dateFormat: true
			},
			email: {
				required: true,
				email: true
			},
			gender: {
				required: true,
				genderFormat: true
			},
			contact: {
				required: true,
				digits: true,
				rangelength:[10,10]
			}
		},
		messages: {
			name: {
				required: "Please supply a player name",
				name:"Not a valid player name"
			},
			email: {
				required: "Please supply a email",
				email:"Not a valid email"
			},
			contact: {
				required: "Please supply a contact",
				contact:"Not a contact"
			}

		}
	});
	$('#playerform').submit(function(e){
		if(!$("#playerform").valid()) return;
	});
});
