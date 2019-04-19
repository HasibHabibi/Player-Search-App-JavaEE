//var message2 = "";
//function isValidTeamCredentials() {
//	var teamNames = document.getElementById("teamNames").value;
//	var coachName = document.getElementById("coachName").value;
//	var b = false;
//
//	if(teamNames=="" ||coachName=="") {
//		message2="All information is required";
//	} else{
//		message2 = "";
//		b = true;
//	}
//	if(b==true) {
//		b = (isValidTeamNames(teamNames)
//				&& isValidTeamCoach(coachName));
//	}
//	
//	document.getElementById("errMsg2").innerText=message2;
//	return b;
//}
//
//
//function isValidTeamNames(teamNames) {
//	var b2 = false;
//	if(teamNames.match(/^[a-zA-Z]{3,15}/)) {
//		b2 = true;
//	} else {
//		message2 = "Invalid team name";
//	}
//	
//	console.log("TeamNames = " + b2);
//	return b2;
//}
//
//function isValidTeamCoach(coachName) {
//	var b3 = false;
//	if(coachName.match(/^[a-zA-Z]{3,15}/)) {
//		b3 = true;
//	} else {
//		message2 = "Invalid coach name";
//	}
//	
//	console.log("coachNames = " + b3);
//	return b3;
//}

$(function() {
	$('#teamform').validate({
		rules: {
			teamName: {
				required: true,
				rangelength:[3,10]
			},
			coachName: {
				required: true,
				rangelength:[3,10]
			}
		},
		messages: {
			teamName: {
				required: "Please supply a team name",
				teamName:"Not a valid name"
			},
			coachName: {
				required: "Please supply a coach name",
				coachName:"Not a valid coach name"
			}
		}
	});
	$('#teamform').submit(function(e){
		if(!$("#teamform").valid()) return;
	});
});

