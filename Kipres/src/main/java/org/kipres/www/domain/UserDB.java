package org.kipres.www.domain;

public class UserDB {
	private int userNum;
	private String userName;
	private String userHP;
	private String userMail;
	private int userGrade;
	private String userId;
	private String userPw;
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
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
	
	@Override
	public String toString() {
		return "UserDB [userNum=" + userNum + ", userName=" + userName + ", userHP=" + userHP + ", userMail=" + userMail
				+ ", userGrade=" + userGrade + ", userId=" + userId + ", userPw=" + userPw + "]";
	}
	
}
