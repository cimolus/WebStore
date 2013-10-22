package com.kassirov.webstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kassirov.domain.Comment;
import com.kassirov.services.CommentService;

@Controller
public class CommentingController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CommentingController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping( value="product/{id}/addComment", method = RequestMethod.POST)
	public String addComment(@ModelAttribute("Comment")Comment comment, @PathVariable("id") int id) {
		commentService.addComment(comment,id);
		return "redirect:/get/product/" + id;
	}
	
}
