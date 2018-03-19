package org.kipres.www.util;

public class AuthInfo {
	private int authNo;
	private String id;
	private String name;
	
	public AuthInfo() {}
	public AuthInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return authNo;
	}

	public String getEmail() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
