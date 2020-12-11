package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {

	@NotNull
	private String userName;
	@NotNull
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", userPassword=" + userPassword + "]";
	}

}
