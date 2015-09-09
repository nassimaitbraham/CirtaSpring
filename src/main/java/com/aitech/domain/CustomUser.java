package com.aitech.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Class qui permet de reccuperer les donnees relative a un user dans le ldap
 * 
 * On pourra reccuperer entre le nom, les roles d'un users...etc
 * 
 * @author nassim AIT BRAHAM
 *
 */
public class CustomUser extends User {

	private static final long serialVersionUID = 6698231753971757890L;

	private String email;
	private String description;
	
	/**
	 *  Constructeur
	 *  
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 * @param email
	 * @param description
	 */

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			String email, String description) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.email = email;
		this.description = description;
	}

	/**
	 * Getters Email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getters description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

}