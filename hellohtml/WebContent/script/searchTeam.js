$(function() {
	$.validator.addMethod("nameFormat",
		    function(value, element) {
		        return value.match(/^[a-zA-Z ]{2,20}$/);
		    },
		    "Please enter a name with only letters & more than one character");
	
	$('#search').validate({
		rules: {
			teamid: {
				required: true,
				digits: true,
				rangelength: [3,3]
			}
		},
		messages: {
			teamid: {
				required: "Please supply a ID",
				name:"Not a valid ID"
			
			}
		}
	});
	$('#search2').validate({
		rules: {
			teamName: {
				required: true,
				nameFormat: true
			}
		},
		messages: {
			teamName: {
				required: "Please supply a Team name",
				teamName:"Not a valid Team name"
			
			}
		}
	});
	$('#search3').validate({
		rules: {
			coachName: {
				required: true,
				nameFormat: true
			}
		},
		messages: {
			coachName: {
				required: "Please supply a Coach Name",
				coachName:"Not a valid Coach name"
			
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
	
});