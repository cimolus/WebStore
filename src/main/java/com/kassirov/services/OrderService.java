package com.kassirov.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kassirov.dao.OrderDao;
import com.kassirov.domain.Basket;
import com.kassirov.domain.Order;
import com.kassirov.domain.User;


@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public void addOrder(Order order) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		order.setUser(user.getUsername());
		orderDao.createOrder(order);
	}

}
