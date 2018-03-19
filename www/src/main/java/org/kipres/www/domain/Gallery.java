package org.kipres.www.domain;

import java.util.Date;

public class Gallery {
	private int galNum;
	private String galTitle;
	private String galContents;
	private Date galInsertDate;
	private Date galUpdate;
	private int galHit;
	private int userNum;
	
	public int getGalNum() {
		return galNum;
	}
	public void setGalNum(int galNum) {
		this.galNum = galNum;
	}
	public String getGalTitle() {
		return galTitle;
	}
	public void setGalTitle(String galTitle) {
		this.galTitle = galTitle;
	}
	public String getGalContents() {
		return galContents;
	}
	public void setGalContents(String galContents) {
		this.galContents = galContents;
	}
	public Date getGalInsertDate() {
		return galInsertDate;
	}
	public void setGalInsertDate(Date galInsertDate) {
		this.galInsertDate = galInsertDate;
	}
	public Date getGalUpdate() {
		return galUpdate;
	}
	public void setGalUpdate(Date galUpdate) {
		this.galUpdate = galUpdate;
	}
	public int getGalHit() {
		return galHit;
	}
	public void setGalHit(int galHit) {
		this.galHit = galHit;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	@Override
	public String toString() {
		return "Gallery [galNum=" + galNum + ", galTitle=" + galTitle + ", galContents=" + galContents
				+ ", galInsertDate=" + galInsertDate + ", galUpdate=" + galUpdate + ", galHit=" + galHit + ", userNum="
				+ userNum + "]";
	}
	
}
