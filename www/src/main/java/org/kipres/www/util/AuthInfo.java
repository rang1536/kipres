package org.kipres.www.util;

public class AuthInfo {
	private String id;
	private String name;
	
	public AuthInfo() {}
	public AuthInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AuthInfo [id=" + id + ", name=" + name + "]";
	}
	
}
