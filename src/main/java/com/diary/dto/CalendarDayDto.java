package com.diary.dto;

import java.time.LocalDate;

public class CalendarDayDto {

	public class CalendarDay {
	    private LocalDate date;
	    private String displayDay; // 1〜31
	    private boolean isToday;
	    private boolean hasDiary;
	    
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public String getDisplayDay() {
			return displayDay;
		}
		public void setDisplayDay(String displayDay) {
			this.displayDay = displayDay;
		}
		public boolean isToday() {
			return isToday;
		}
		public void setToday(boolean isToday) {
			this.isToday = isToday;
		}
		public boolean isHasDiary() {
			return hasDiary;
		}
		public void setHasDiary(boolean hasDiary) {
			this.hasDiary = hasDiary;
		}
	    
	}

}
