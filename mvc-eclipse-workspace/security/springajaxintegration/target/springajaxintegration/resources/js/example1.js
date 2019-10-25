function getCitiesForSelectedState(){
	$('#loading').html('<img src="./resources/img/ajax-loader.gif">');
		var state = $('#state').val();
		$.ajax({
			url : 'example1/getCitiesForSelectedState',
			method : 'post',
			ContentType : 'json',
			data : {
				state : state
			},

			success : function(response) {
				var options = '';
				if (response != null) {
					$(response).each(function(index, value) {
						options = options + '<option>' + value + '</option>';
					});
					$('#city').html(options);
				}
				$('#loading').html('');
			}
		});
	}