package org.kipres.www.domain;

public class UserDb {
	private String userName;
	private String userHP;
	private String userMail;
	private int userGrade;
	private String userId;
	private String userPw;
	
	public UserDb() {
	}
	
	public UserDb(String userId, String userPw, String userName, String userMail, String userHP, int userGrade) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userMail = userMail;
		this.userHP = userHP;
		this.userGrade = userGrade;
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
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
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
	
	public boolean matchPassword(String pwd) {
		return this.userPw.equals(pwd);
	}
	
	@Override
	public String toString() {
		return "UserDB [userName=" + userName + ", userHP=" + userHP + ", userMail=" + userMail
				+ ", userGrade=" + userGrade + ", userId=" + userId + ", userPw=" + userPw + "]";
	}
	
}
