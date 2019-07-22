$(document).ready(function() {
	$('#inputEmail4').blur(function() {
		$.ajax({
			url : 'getEmail',
			data : {
				emailId : $('#inputEmail4').val()
			},
			success : function(responseText) {
				$('#ajaxResponse').text(responseText);
			}
		});
	});
});