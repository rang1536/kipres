package org.kipres.www.util;

import java.util.Map;

public class RegisterRequest {

	private String userId;
	private String userPw;
	private String confirmUserPw;
	private String userMail;
	private String userName;
	private String userHP;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getConfirmUserPw() {
		return confirmUserPw;
	}
	public void setConfirmUserPw(String confirmUserPw) {
		this.confirmUserPw = confirmUserPw;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHP() {
		return userHP;
	}
	public void setUserHP(String userHP) {
		this.userHP = userHP;
	}

	public boolean isPasswordEqualToConfirmPassword() {
		return userPw != null && userPw.equals(confirmUserPw);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, userId, "id");
		checkEmpty(errors, userName, "name");
		checkEmpty(errors, userHP, "hp");
		checkEmpty(errors, userMail, "mail");
		checkEmpty(errors, userPw, "password");
		checkEmpty(errors, confirmUserPw, "confirmPassword");
		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirmPassword()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName,  Boolean.TRUE);
		}
	}
	@Override
	public String toString() {
		return "RegisterRequest [userId=" + userId + ", userPw=" + userPw + ", confirmUserPw=" + confirmUserPw
				+ ", userMail=" + userMail + ", userName=" + userName + ", userHP=" + userHP + "]";
	}

}