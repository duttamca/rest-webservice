package com.sanjiv.dao;

import java.util.List;

import com.sanjiv.model.Users;

public interface UsersDaoInterface {

	public List<Users> getUsers();
	
	public Users getUserById(int userid);
	
	public void deleteUsers();
	
	public void deleteUserById(int userid);
	
	public void addUser(Users user);

	void updateUser(Users user);
}
