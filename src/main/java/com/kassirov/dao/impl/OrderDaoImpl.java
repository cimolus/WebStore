package com.kassirov.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kassirov.dao.OrderDao;
import com.kassirov.domain.Order;


@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public List<Order> readAllOrders() {
		
		return null;
	}

	@Override
	public Order readOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	
	

}
