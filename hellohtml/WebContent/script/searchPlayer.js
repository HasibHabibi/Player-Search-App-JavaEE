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
	
	$.validator.addMethod("idFormat",
		    function(value, element) {
		        return value.match(/[Pp]{1}[a-zA-Z]{2}[0-9]{7}$/);
		    },
		    "Enter valid ID e.g: Pxx#######");
	
	$('#search').validate({
		rules: {
			playerid: {
				required: true,
				idFormat: true
			}
		},
		messages: {
			playerid: {
				required: "Please supply a ID",
				name:"Not a valid ID"
			
			}
		}
	});
	$('#search2').validate({
		rules: {
			name: {
				required: true,
				nameFormat: true
			}
		},
		messages: {
			name: {
				required: "Please supply a player name",
				name:"Not a valid player name"
			
			}
		}
	});
	$('#search3').validate({
		rules: {
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			email: {
				required: "Please supply a Email",
				email:"Not a valid Email"
			
			}
		}
	});
	$('#search4').validate({
		rules: {
			dob: {
				required: true,
				date: true
			}
		}
	});
	$('#search5').validate({
		rules: {
			contact: {
				required: true,
				digits: true,
				rangelength:[10,10]
			}
		},
		messages: {
			contact: {
				required: "Please supply a contact",
				contact:"Not a contact"
			
			}
		}
	});
	$('#search6').validate({
		rules: {
			gender: {
				required: true,
				genderFormat: true
			}
		}
	});
	$('#search7').validate({
		rules: {
			teamName: {
				required: true,
				rangelength:[3,10]
			}
		},
		messages: {
			teamName: {
				required: "Please supply a team name",
				teamName:"Not a valid team name"
			}
		}
	});
	$('#search').submit(function(e){
		if(!$("#search").valid()) return;
	});
	$('#search2').submit(function(e){
		if(!$("#search2").valid()) return;
	});
	$('#search3').submit(function(e){
		if(!$("#search3").valid()) return;
	});
	$('#search4').submit(function(e){
		if(!$("#search4").valid()) return;
	});
	$('#search5').submit(function(e){
		if(!$("#search5").valid()) return;
	});
	$('#search6').submit(function(e){
		if(!$("#search6").valid()) return;
	});
	$('#search7').submit(function(e){
		if(!$("#search7").valid()) return;
	});
});

