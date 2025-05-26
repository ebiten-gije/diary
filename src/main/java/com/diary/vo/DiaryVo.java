package com.diary.vo;

import java.util.Date;

public class DiaryVo {
	
	private int dId;
	private int uId;
	private Date date;
	private String title;
	private String content;
	
	public DiaryVo() {
		
	}
	
	public DiaryVo(int dId, int uId, Date date, String title, String content) {
		this.dId = dId;
		this.uId = uId;
		this.date = date;
		this.title = title;
		this.content = content;
	}
	
	public int getUId() {
		return uId;
	}
	
	public void setUId(int uId) {
		this.uId = uId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title= title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public int getDId() {
		return dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	@Override
	public String toString() {
		return "DiaryVo [dId=" + dId + ", uId=" + uId + ", date=" + date + ", title=" + title + ", content=" + content
				+ "]";
	}

}
