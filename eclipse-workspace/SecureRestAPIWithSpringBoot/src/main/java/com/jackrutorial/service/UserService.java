package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.bean.User;

public interface UserService {
	 public List<User> getAllUser();
	 
	 public User getUserById(int id);


}
