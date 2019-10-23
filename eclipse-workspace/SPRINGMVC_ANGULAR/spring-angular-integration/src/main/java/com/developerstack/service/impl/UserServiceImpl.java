/**
 * 
 */
package com.developerstack.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.developerstack.model.UserDetails;
import com.developerstack.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public void validateUser(Map<String, String> user, HttpServletRequest request) {
		String userName = user.get("email");
		String password = user.get("password");
		if(!(userName.equals("admin") && password.equals("admin"))) {
			throw new RuntimeException("Invalid user");
		}
		
	}

	public List<UserDetails> getUserDetails() {
		UserDetails ud1 = new UserDetails();
		ud1.setEmail("john@example.com");
		ud1.setFirstName("John");
		ud1.setLastName("Doe");
		UserDetails ud2 = new UserDetails();
		ud2.setEmail("vicky@gmail.com");
		ud2.setFirstName("vicky");
		ud2.setLastName("Ray");
		UserDetails ud3 = new UserDetails();
		ud3.setEmail("abc@yahoo.co.in");
		ud3.setFirstName("abc");
		ud3.setLastName("greg");
		UserDetails ud4 = new UserDetails();
		ud4.setFirstName("xyz");
		ud4.setEmail("xyz@gmail.com");
		ud4.setLastName("Bard");
		return Arrays.asList(ud1, ud2, ud3, ud4);
	}

}
