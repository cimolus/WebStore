package com.kassirov.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kassirov.dao.CommentDao;
import com.kassirov.domain.Comment;


@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createComment(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}

}
