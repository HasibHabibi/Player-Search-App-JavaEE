$(function() {
	$.validator.addMethod("idFormat",
		    function(value, element) {
		        return value.match(/[Pp]{1}[a-zA-Z]{2}[0-9]{7}$/);
		    },
		    "Enter valid ID e.g: Pxx#######");
	
	$('#updateform').validate({
		rules: {
			playerid: {
				required: true,
				idFormat: true
			}
		},
		messages: {
			playerid: {
				required: "Please supply ID",
			}
		}
	});
	$('#deleteform').submit(function(e){
		if(!$("#deleteform").valid()) return;
	});
});