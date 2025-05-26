package com.diary.vo;

public class DiaryAnalysisVo {

	private int dId;
	private String summary;
	private String emotion;
	private String weatherStyle;
	
	public DiaryAnalysisVo() {
		
	}
	
	public DiaryAnalysisVo(int dId, String summary, String emotion, String weatherStyle) {
		this.dId = dId;
		this.summary = summary;
		this.emotion = emotion;
		this.weatherStyle = weatherStyle;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getWeatherStyle() {
		return weatherStyle;
	}

	public void setWeatherStyle(String weatherStyle) {
		this.weatherStyle = weatherStyle;
	}

	@Override
	public String toString() {
		return "DiaryAnalysisVo [summary=" + summary + ", emotion=" + emotion + ", weatherStyle=" + weatherStyle + "]";
	}
	
	
}
