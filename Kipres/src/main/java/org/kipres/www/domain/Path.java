package org.kipres.www.domain;

public class Path {
	private int fileNum;
	private String filePath;
	private String fileName;
	private int ntNum;
	private int refNum;
	private int tsNum;
	private int galNum;
	private String fileRandomName;
	
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getNtNum() {
		return ntNum;
	}
	public void setNtNum(int ntNum) {
		this.ntNum = ntNum;
	}
	public int getRefNum() {
		return refNum;
	}
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	public int getTsNum() {
		return tsNum;
	}
	public void setTsNum(int tsNum) {
		this.tsNum = tsNum;
	}
	public int getGalNum() {
		return galNum;
	}
	public void setGalNum(int galNum) {
		this.galNum = galNum;
	}
	public String getFileRandomName() {
		return fileRandomName;
	}
	public void setFileRandomName(String fileRandomName) {
		this.fileRandomName = fileRandomName;
	}
	
	@Override
	public String toString() {
		return "Path [fileNum=" + fileNum + ", filePath=" + filePath + ", fileName=" + fileName + ", ntNum=" + ntNum
				+ ", refNum=" + refNum + ", tsNum=" + tsNum + ", galNum=" + galNum + ", fileRandomName="
				+ fileRandomName + "]";
	}
	
}
