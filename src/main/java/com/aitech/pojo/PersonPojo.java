package com.aitech.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Plain Old Java Object utilise pour l'ors d'appel web service
 * 
 * @author nassim AIT BRAHAM
 *
 */
@XmlRootElement(name = "Person")
public class PersonPojo implements Serializable {

	private static final long serialVersionUID = -5527566248002296042L;

	private Integer id;

	private String firstName;

	private String lastName;

	private Double money;

	private byte[] photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
