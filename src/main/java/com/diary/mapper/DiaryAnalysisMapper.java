package com.diary.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.diary.vo.DiaryAnalysisVo;

@Mapper
public interface DiaryAnalysisMapper {
    void insertAnalysis(DiaryAnalysisVo analysis);
    DiaryAnalysisVo findByDiaryId(int dId);
}
