package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.UserDao;
import com.jackrutorial.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	 UserDao userDao;
	 
	 @Autowired
	 public void setUserDao(UserDao userDao) {
	  this.userDao = userDao;
	 }


	public List listAllUser() {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	public List findUserById(User user) {
		// TODO Auto-generated method stub
		return userDao.findUserById(user);
	}

}
