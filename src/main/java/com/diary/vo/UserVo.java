package com.diary.vo;

public class UserVo {
	
	private int uId;
	private String name;
	private String password;
	
	public UserVo() {
		
	}
	
	public UserVo(int uId, String name, String password) {
		this.uId = uId;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return uId;
	}

	public void setId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
