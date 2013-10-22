package com.kassirov.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kassirov.dao.UserDao;
import com.kassirov.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public User getUserByUsername(String username) {
		return userDao.readUserByUsername(username);
	}
	
	@Transactional
	public void createNewUser(User user) {
		user.setAuthorities("ROLE_USER");
		user.setActive(true);
		userDao.createUser(user);
	}
	
	@Transactional
	public List<User> getAllUsers() {
		return userDao.readAllUsers();
	}
	
	
}
