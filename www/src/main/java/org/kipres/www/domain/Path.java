package org.kipres.www.domain;

public class Path {
	private int fileNum;
	private String filePath;
	private String fileName;
	private int fileType;
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
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	public String getFileRandomName() {
		return fileRandomName;
	}
	public void setFileRandomName(String fileRandomName) {
		this.fileRandomName = fileRandomName;
	}
	@Override
	public String toString() {
		return "Path [fileNum=" + fileNum + ", filePath=" + filePath + ", fileName=" + fileName + ", fileType="
				+ fileType + ", fileRandomName=" + fileRandomName + "]";
	}
	
}
