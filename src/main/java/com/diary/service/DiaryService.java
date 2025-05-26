package com.diary.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diary.mapper.DiaryMapper;
import com.diary.vo.DiaryVo;

@Service
public class DiaryService {

	private final DiaryMapper diaryMapper;
	
	public DiaryService(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }
	
	//今月の情報だけ読んでくる形
	public List<String> findDiaryDatesByMonth(int uId, int year, int month) {
	    LocalDate start = LocalDate.of(year, month, 1);
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
	    return diaryMapper.findDiaryDates(uId, start, end);
	}


	public DiaryVo findDiaryByDate(int userId, String date) {
		Date diaryDate = java.sql.Date.valueOf(date);
        return diaryMapper.findDiaryByDate(userId, diaryDate);
    }

    public void writeDiary(DiaryVo diary) {
//        diaryMapper.insertDiary(diary);
        diaryMapper.insert(diary);
    }
}
