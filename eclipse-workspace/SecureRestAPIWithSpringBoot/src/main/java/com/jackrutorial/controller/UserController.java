package com.jackrutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jackrutorial.bean.User;
import com.jackrutorial.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/user/")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int userId) {
		return userService.getUserById(userId);
	}

}