package org.kipres.www.domain;

public class Notice {
	private int ntNum;
	private String ntTitle;
	private String ntContents;
	private String ntInsertDate;
	private String ntUpdate;
	private int ntHit;
	private int userNum;
	
	
	public int getNtNum() {
		return ntNum;
	}
	public void setNtNum(int ntNum) {
		this.ntNum = ntNum;
	}
	public String getNtTitle() {
		return ntTitle;
	}
	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}
	public String getNtContents() {
		return ntContents;
	}
	public void setNtContents(String ntContents) {
		this.ntContents = ntContents;
	}
	public String getNtInsertDate() {
		return ntInsertDate;
	}
	public void setNtInsertDate(String ntInsertDate) {
		this.ntInsertDate = ntInsertDate;
	}
	public String getNtUpdate() {
		return ntUpdate;
	}
	public void setNtUpdate(String ntUpdate) {
		this.ntUpdate = ntUpdate;
	}
	public int getNtHit() {
		return ntHit;
	}
	public void setNtHit(int ntHit) {
		this.ntHit = ntHit;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	@Override
	public String toString() {
		return "Notice [ntNum=" + ntNum + ", ntTitle=" + ntTitle + ", ntContents=" + ntContents + ", ntInsertDate="
				+ ntInsertDate + ", ntUpdate=" + ntUpdate + ", ntHit=" + ntHit + ", userNum=" + userNum + "]";
	}

	
}
