package com.kassirov.webstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kassirov.services.UserService;


@Controller
@RequestMapping("/admin")
public class AdministrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("users", userService.getAllUsers());
		return mav;
	}
	
}
