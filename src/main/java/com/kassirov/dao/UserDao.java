package com.kassirov.dao;

import java.util.List;

import com.kassirov.domain.User;

public interface UserDao {
	public void createUser(User user);
	public User readUserByUsername(String username);
	public List<User> readAllUsers();
	public void updateUser(User user);
	public void deleteUser(String username);
}
