package org.kipres.www.domain;

public class Thesis {
	private int tsNum;
	private String tsTitle;
	private String tsWriter;
	private String tsPublic;
	private String tsContain;
	private String tsPage;
	private String tsISSN;
	private String tsInstitution;
	private int userNum;
	
	public int getTsNum() {
		return tsNum;
	}
	public void setTsNum(int tsNum) {
		this.tsNum = tsNum;
	}
	public String getTsTitle() {
		return tsTitle;
	}
	public void setTsTitle(String tsTitle) {
		this.tsTitle = tsTitle;
	}
	public String getTsWriter() {
		return tsWriter;
	}
	public void setTsWriter(String tsWriter) {
		this.tsWriter = tsWriter;
	}
	public String getTsPublic() {
		return tsPublic;
	}
	public void setTsPublic(String tsPublic) {
		this.tsPublic = tsPublic;
	}
	public String getTsContain() {
		return tsContain;
	}
	public void setTsContain(String tsContain) {
		this.tsContain = tsContain;
	}
	public String getTsPage() {
		return tsPage;
	}
	public void setTsPage(String tsPage) {
		this.tsPage = tsPage;
	}
	public String getTsISSN() {
		return tsISSN;
	}
	public void setTsISSN(String tsISSN) {
		this.tsISSN = tsISSN;
	}
	public String getTsInstitution() {
		return tsInstitution;
	}
	public void setTsInstitution(String tsInstitution) {
		this.tsInstitution = tsInstitution;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	@Override
	public String toString() {
		return "Thesis [tsNum=" + tsNum + ", tsTitle=" + tsTitle + ", tsWriter=" + tsWriter + ", tsPublic=" + tsPublic
				+ ", tsContain=" + tsContain + ", tsPage=" + tsPage + ", tsISSN=" + tsISSN + ", tsInstitution="
				+ tsInstitution + ", userNum=" + userNum + "]";
	}
	
}
