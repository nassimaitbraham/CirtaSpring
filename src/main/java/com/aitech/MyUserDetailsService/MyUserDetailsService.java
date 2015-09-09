package com.aitech.MyUserDetailsService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService  {
	
	private Map<String, User> availableUsers = new HashMap<String, User>();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		

	        UserDetails user = availableUsers.get(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Username not found");
	        } else {
	            return availableUsers.get(username);
	        }
	}

}
