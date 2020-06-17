package com.mthree.users;

public class UserSignupDto {
	
	private String userName;
	private String password;
	private String passwordConfirm;
	
	public UserSignupDto(String userName, String password, String passwordConfirm) {
		super();
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	

}
