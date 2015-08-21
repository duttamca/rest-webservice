package com.sanjiv.service;

import java.util.ArrayList;
import java.util.List;

import com.sanjiv.dao.UserDao;
import com.sanjiv.model.Users;

public class UserService {
	
	UserDao userDao;
	
	public UserService(){
		
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService(UserDao userDao){
		this.userDao = userDao;
	}
	
	public void addUser(Users user){
		userDao.addUser(user);
	}
	
	public Users getUserById(int userid){
		Users user = userDao.getUserById(userid);
		return user;
	}
	
	public List<Users> getUsers(){
		
		List<Users> userList = new ArrayList<Users>();
		userList = userDao.getUsers();
		return userList;
		
	}
	
	public void deleteUser(int userid){
		userDao.deleteUserById(userid);
	}
	
	public void deleteUsers(){
		userDao.deleteUsers();
	}

	public void updateUser(Users user){
		userDao.updateUser(user);
	}
}
