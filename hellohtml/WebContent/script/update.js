$(function() {
	
	$('#updateform').validate({
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
	$('#updateform').submit(function(e){
		if(!$("#updateform").valid()) return;
	});
});