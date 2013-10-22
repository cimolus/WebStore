package com.kassirov.dao;

import com.kassirov.domain.Comment;

public interface CommentDao {
	public void createComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(Comment comment);
}
