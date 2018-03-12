package org.kipres.www.domain;

import java.util.Date;

public class Reference {
	private int refNum;
	private String refTitle;
	private String refContents;
	private Date refInsertDate;
	private Date refUpdate;
	private int refHit;
	private int userNum;
	public int getRefNum() {
		return refNum;
	}
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	public String getRefTitle() {
		return refTitle;
	}
	public void setRefTitle(String refTitle) {
		this.refTitle = refTitle;
	}
	public String getRefContents() {
		return refContents;
	}
	public void setRefContents(String refContents) {
		this.refContents = refContents;
	}
	public Date getRefInsertDate() {
		return refInsertDate;
	}
	public void setRefInsertDate(Date refInsertDate) {
		this.refInsertDate = refInsertDate;
	}
	public Date getRefUpdate() {
		return refUpdate;
	}
	public void setRefUpdate(Date refUpdate) {
		this.refUpdate = refUpdate;
	}
	public int getRefHit() {
		return refHit;
	}
	public void setRefHit(int refHit) {
		this.refHit = refHit;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	@Override
	public String toString() {
		return "Reference [refNum=" + refNum + ", refTitle=" + refTitle + ", refContents=" + refContents
				+ ", refInsertDate=" + refInsertDate + ", refUpdate=" + refUpdate + ", refHit=" + refHit + ", userNum="
				+ userNum + "]";
	}
	
}
