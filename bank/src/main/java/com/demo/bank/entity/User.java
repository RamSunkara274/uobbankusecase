package com.demo.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {

	@Id
	@NotNull(message = "ID is required")
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@Column(name = "username")
	@NotEmpty(message = "userName  is required")
	private String userName;

	@Column(name = "email")
	@NotNull(message = "User email is required")
	private String email;
	@Column(name = "password")
	@NotNull(message = "User password is required")
	private String password;
	@Column(name = "address")
	@NotNull(message = "User address is required")
	private String address;
	@Column(name = "adharNumber")
	@NotNull(message = "User adharNumber is required")
	private String adharNumber;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", adharNumber=" + adharNumber + "]";
	}

}
