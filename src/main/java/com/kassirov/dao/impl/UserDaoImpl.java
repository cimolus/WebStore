package com.kassirov.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kassirov.dao.UserDao;
import com.kassirov.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User readUserByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().get(User.class, username);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public void deleteUser(String username) {
		sessionFactory.getCurrentSession().delete(username);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
