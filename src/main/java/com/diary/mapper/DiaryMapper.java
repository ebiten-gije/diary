package com.diary.mapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.diary.vo.DiaryVo;

@Mapper
public interface DiaryMapper {

	//대시보드 불러오기
	List<String> findDiaryDates (@Param("uId") int uId, @Param("start") LocalDate start, @Param("end") LocalDate end);
	
	//일기 상세보기
	DiaryVo findDiaryByDate(@Param("userId") int userId, @Param("date") Date date);

	//일기 작성
    void insertDiary(DiaryVo diary);
    
    void insert(DiaryVo diary);
    
}
