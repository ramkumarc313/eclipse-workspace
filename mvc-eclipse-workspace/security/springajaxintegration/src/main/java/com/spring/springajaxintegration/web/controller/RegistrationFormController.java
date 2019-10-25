package com.spring.springajaxintegration.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example3")
public class RegistrationFormController {

	@RequestMapping(value = "submitDetailsToServer", method = RequestMethod.POST)
	public @ResponseBody String submitDetailsToServer(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "nickName", required = true) String nickName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "repeatPassword", required = true) String repeatPassword,
			@RequestParam(value = "emailId", required = true) String emailId,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber,
			@RequestParam(value = "gender", required = true) String gender,
			@RequestParam(value = "state", required = true) String state,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "postalCode", required = true) String postalCode,
			@RequestParam(value = "country", required = true) String country) {
		String stringToReturn = "Registration Details: <br><br>Name: " + name + "<br> Nick Name: " + nickName
				+ "<br> Email ID: " + emailId + "<br> Mobile Number: " + mobileNumber
				+ "<br> Gender: " + gender + "<br> State: " + state + "<br> City: "
				+ city + "<br> Postal Code: " + postalCode + "<br> Country: "
				+ country;
		return stringToReturn;
	}
}
