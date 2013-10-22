package com.kassirov.webstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kassirov.domain.User;
import com.kassirov.services.UserService;


@Controller
public class RegistrationController {
	
	//private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String registrationForm(Model model) {
		model.addAttribute("User",new User());
		return "registration";
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("User")User user) {
		userService.createNewUser(user);
		return "signin";
	}
	
}
