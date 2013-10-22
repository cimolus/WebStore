package com.kassirov.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WebstoreUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(WebstoreUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		logger.debug("Invoke loadUserByUsername");
		return userService.getUserByUsername(arg0);
	}

}
