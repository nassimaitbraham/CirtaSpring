package com.aitech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Model correspondant a la table des roles dans la base de donnees
 * 
 * @author nasnet
 *
 */
@Entity
@Table(name = "user_roles", catalog = "cirta_data_base")
public class UserRoles implements java.io.Serializable {

	private Integer userId;
	private String authority;

	public UserRoles() {
	}

	public UserRoles(String authority) {
		this.authority = authority;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "authority", nullable = false, length = 225)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
