package org.kipres.www.domain;

public class UserDB {
	private int userNum;
	private String userName;
	private String userHP;
	private String userMail;
	private int userGrade;
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
	
	@Override
	public String toString() {
		return "UserDB [userNum=" + userNum + ", userName=" + userName + ", userHP=" + userHP + ", userMail=" + userMail
				+ ", userGrade=" + userGrade + "]";
	}
	
}
