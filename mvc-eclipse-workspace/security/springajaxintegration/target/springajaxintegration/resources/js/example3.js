$('#validationForm')
				.submit(
						function(e) {
							/* display loading image until reponse from server */
							$('#loading')
									.html(
											'<img src="./resources/img/ajax-loader.gif">');

							/* read form field values */
							var name = $('#name').val();
							var nickName = $('#nickName').val();
							var password = $('#password').val();
							var repeatPassword = $('#repeatPassword').val();
							var emailId = $('#emailId').val();
							var mobileNumber = $('#mobileNumber').val();
							var gender = $("form input[type='radio']:checked")
									.val();
							var state = $('#state').val();
							var city = $('#city').val();
							var postalCode = $('#postalCode').val();
							var country = $('#country').val();

							/* make AJAX call to post data to server */
							$
									.post(
											'./example3/submitDetailsToServer?name='
													+ name + '&nickName='
													+ nickName + '&password='
													+ password
													+ '&repeatPassword='
													+ repeatPassword
													+ '&emailId=' + emailId
													+ '&mobileNumber='
													+ mobileNumber + '&gender='
													+ gender + '&state='
													+ state + '&city=' + city
													+ '&postalCode='
													+ postalCode + '&country='
													+ country,
											function(response) {

												/* check whether reponse is null */
												if (response != null) {
													$('#submitedDetails')
															.html(
																	'<font color="green">'
																			+ response
																			+ '</font>');
												} else {
													$('#submitedDetails')
															.html(
																	'<font color="red">Form submission failed.</font>');
												}

												/* display AJAX response from server */
												$('#submitedDetails')
														.html(
																'<br><font color="green">'
																		+ response
																		+ '</font><br>');

												/* clear form fields after getting response from the server*/
												$('#name').val('');
												$('#nickName').val('');
												$('#password').val('');
												$('#repeatPassword').val('');
												$('#emailId').val('');
												$('input[type=radio]').prop(
														"checked", false);
												$('#state').val('Select State');
												$('#city').val('Select City');
												$('#postalCode').val('');
												$('#country').val(
														'Select Country');

												/* remove loading image */
												$('#loading').html('');
											});
							e.preventDefault(); // prevent actual form submit
						});

		/* reset values of form fields */
		$('#reset').click(function(e) {
			/* reset form fields */
			$('#name').val('');
			$('#nickName').val('');
			$('#password').val('');
			$('#repeatPassword').val('');
			$('#emailId').val('');
			$('input[type=radio]').prop("checked", false);
			$('#state').val('Select State');
			$('#city').val('Select City');
			$('#postalCode').val('');
			$('#country').val('Select Country');
			$('#submitedDetails').html('');
			
			/* reset validation errors */
		});
		
		function checkNameForEmpty() {
			var name = $('#name').val();

			$.post("./example3/validate/checkNameForEmpty", {
				name : name
			}, function(result) {
				if (result == 'EMPTY') {
					$('#name_blank_result').html('Enter your name');
				} else {
					$('#name_blank_result').html('');
				}
			});
		}
		
		function checkPasswordForEmpty() {
			var password = $('#password').val();

			$.post("./example3/validate/checkPasswordForEmpty", {
				password : password
			}, function(result) {
				if (result == 'EMPTY') {
					$('#password_blank_result').html('Enter password');
				} else {
					$('#password_blank_result').html('');
				}
			});
		}
		
		function checkRepeatPasswordForEmpty() {
			var repeatPassword = $('#repeatPassword').val();

			$.post("./example3/validate/checkRepeatPasswordForEmpty", {
				repeatPassword : repeatPassword
			}, function(result) {
				if (result == 'EMPTY') {
					$('#repeat_password_blank_result').html('Enter repeat password');
				} else {
					$('#repeat_password_blank_result').html('');
				}
			});
		}
		
		function checkEmailIdForEmpty() {
			var emailId = $('#emailId').val();

			$.post("./example3/validate/checkEmailIdForEmpty", {
				emailId : emailId
			}, function(result) {
				if (result == 'EMPTY') {
					$('#email_id_blank_result').html('Enter email id');
				} else {
					$('#email_id_blank_result').html('');
				}
			});
		}
		
		function checkMobileNumberForEmpty() {
			var mobileNumber = $('#mobileNumber').val();

			$.post("./example3/validate/checkMobileNumberForEmpty", {
				mobileNumber : mobileNumber
			}, function(result) {
				if (result == 'EMPTY') {
					$('#mobile_number_blank_result').html('Enter mobile number');
				} else {
					$('#mobile_number_blank_result').html('');
				}
			});
		}
		
		function checkStateForEmpty() {
			var state = $('#state').val();

			$.post("./example3/validate/checkStateForEmpty", {
				state : state
			}, function(result) {
				if (result == 'EMPTY') {
					$('#state_blank_result').html('Select state');
				} else {
					$('#state_blank_result').html('');
				}
			});
		}
		
		function checkCityForEmpty() {
			var city = $('#city').val();

			$.post("./example3/validate/checkCityForEmpty", {
				city : city
			}, function(result) {
				if (result == 'EMPTY') {
					$('#city_blank_result').html('Select city');
				} else {
					$('#city_blank_result').html('');
				}
			});
		}
		
		function checkPostalCodeForEmpty() {
			var postalCode = $('#postalCode').val();

			$.post("./example3/validate/checkPostalCodeForEmpty", {
				postalCode : postalCode
			}, function(result) {
				if (result == 'EMPTY') {
					$('#postal_code_blank_result').html('Enter postal code');
				} else {
					$('#postal_code_blank_result').html('');
				}
			});
		}
		
		function checkCountryForEmpty() {
			var country = $('#country').val();

			$.post("./example3/validate/checkCountryForEmpty", {
				country : country
			}, function(result) {
				if (result == 'EMPTY') {
					$('#country_blank_result').html('Select country');
				} else {
					$('#country_blank_result').html('');
				}
			});
		}
		
		function checkMobileNumberForWrongPattern() {
			var mobileNumber = $('#mobileNumber').val();

			$.post("./example3/validate/checkMobileNumberForWrongPattern", {
				mobileNumber : mobileNumber
			}, function(result) {
				if (result == 'WRONG_PATTERN') {
					$('#mobile_number_pattern_result').html('Enter correct mobile number');
				} else {
					$('#mobile_number_pattern_result').html('');
				}
			});
		}
		
		function checkPostalCodeForWrongPattern() {
			var postalCode = $('#postalCode').val();

			$.post("./example3/validate/checkPostalCodeForWrongPattern", {
				postalCode : postalCode
			}, function(result) {
				if (result == 'WRONG_PATTERN') {
					$('#postal_code_pattern_result').html('Enter correct postal code');
				} else {
					$('#postal_code_pattern_result').html('');
				}
			});
		}
		
		function checkEmailIdForWrongPattern() {
			var emailId = $('#emailId').val();

			$.post("./example3/validate/checkEmailIdForWrongPattern", {
				emailId : emailId
			}, function(result) {
				if (result == 'WRONG_PATTERN') {
					$('#email_id_pattern_result').html('Enter correct email id');
				} else {
					$('#email_id_pattern_result').html('');
				}
			});
		}
		
		function checkPasswordForWrongPattern() {
			var password = $('#password').val();

			$.post("./example3/validate/checkPasswordForWrongPattern", {
				password : password
			}, function(result) {
				if (result == 'WRONG_PATTERN') {
					$('#password_pattern_result').html('Enter correct password');
				} else {
					$('#password_pattern_result').html('');
				}
			});
		}
		
		function checkRepeatPasswordForEqual() {
			var password = $('#password').val();
			var repeatPassword = $('#repeatPassword').val();

			$.post("./example3/validate/checkRepeatPasswordForEqual", {
				password : password,
				repeatPassword : repeatPassword
			}, function(result) {
				if (result == 'NOT_SAME') {
					$('#repeat_password_match_result').html('Password must match with one you entered previously');
				} else {
					$('#repeat_password_match_result').html('');
				}
			});
		}