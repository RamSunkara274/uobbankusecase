package com.demo.bank.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RegistrationModel {

	// @NotBlank(message = "userName field should be manditory")
	private String userName;
	// @NotBlank(message = "email field should be manditory")
	private String email;
	// @NotBlank(message = "password field should be manditory")
	private String password;
	// @NotBlank(message = "address field should be manditory")
	private String address;
	// @NotBlank(message = "adharNumber field should be manditory")
	private String adharNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

}
