$(function() {
	$.validator.addMethod("idFormat",
		    function(value, element) {
		        return value.match(/[Pp]{1}[a-zA-Z]{2}[0-9]{7}$/);
		    },
		    "Enter valid ID e.g: Pxx#######");
	$.validator.addMethod("passwordFormat",
		    function(value, element) {
		        return value.match(/^[a-zA-Z0-9]{3}@[0-9]{3}$/);
		    },
		    "Enter valid password e.g: xxx@###");
	
	$('#registerform').validate({
		rules: {
			playerid: {
				required: true,
				idFormat: true
			},
			password: {
				required: true,
				passwordFormat: true
			}
		},
		messages: {
			playerid: {
				required: "Please supply ID",
			},
			password: {
				required: "Please supply a password",
			}
		}
	});
	$('#registerform').submit(function(e){
		if(!$("#registerform").valid()) return;
	});
});

function toggle() {
	var noButton = document.getElementById("no");
	var yesButton = document.getElementById("yes");
	if(noButton.checked){
		alert("Active Player Only");
		yesButton.checked = true;
	}
}

function checkPassword(form) {
	password = form.password.value;
	password2 = form.password2.value;
	
	if(password != password2) {
		alert("\nPassword did not match: Please try again...")
		return false;
	}
	else {
		return true;
	}
}