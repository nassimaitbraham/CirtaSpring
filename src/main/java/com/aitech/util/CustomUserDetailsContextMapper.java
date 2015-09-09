package com.aitech.util;

import java.util.Collection;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Component;

import com.aitech.domain.CustomUser;

@Component
public class CustomUserDetailsContextMapper implements UserDetailsContextMapper  {

	
	private String email = null;
	private String description = null;
	
	private CustomUser userDetails = null;

	public CustomUserDetailsContextMapper() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		
		Attributes attributes = ctx.getAttributes();
	
		try {
			email = (String) attributes.get("mail").get();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CustomUser userDetails = new CustomUser(username, "", true, true, true, true, authorities, email, description);
		this.userDetails = userDetails;
		return userDetails;
	}

	@Override
	public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
		// TODO Auto-generated method stub
		
	}
 
	public CustomUser getUserDetails() {
		return this.userDetails;
	}
	

 
}