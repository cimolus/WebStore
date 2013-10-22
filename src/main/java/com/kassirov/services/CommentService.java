package com.kassirov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kassirov.dao.CommentDao;
import com.kassirov.domain.Comment;
import com.kassirov.domain.User;


@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Transactional
	public void addComment(Comment comment, int id) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		comment.setAuthor(user.getUsername());
		comment.setComment_product_id(id);
		commentDao.createComment(comment);
	}

}