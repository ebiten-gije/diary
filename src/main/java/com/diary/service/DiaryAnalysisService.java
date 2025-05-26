package com.diary.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.diary.mapper.DiaryAnalysisMapper;
import com.diary.vo.DiaryAnalysisVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DiaryAnalysisService {

    private final DiaryAnalysisMapper analysisMapper;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public DiaryAnalysisService(DiaryAnalysisMapper analysisMapper) {
        this.analysisMapper = analysisMapper;
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:5000")
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public DiaryAnalysisVo analyzeDiary(String title, String content, int dId) {
        try {
            Map<String, String> requestBody = Map.of(
                    "title", title,
                    "content", content
            );

            // まずは Flask からのレスポンスを String として受け取る
            String jsonResponse = webClient.post()
                    .uri("/analyze")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)  // DiaryAnalysisVoではなくまず文字列で
                    .block();

            // JSON文字列 -> DiaryAnalysisVo に変換
            DiaryAnalysisVo analysis = objectMapper.readValue(jsonResponse, DiaryAnalysisVo.class);
            
         // jsonResponse をログで確認
            System.out.println("AIからの応答: " + analysis);
            
            analysis.setdId(dId);

            // DBに保存
            analysisMapper.insertAnalysis(analysis);
            return analysis;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public DiaryAnalysisVo getDA(int uId, int dId) {
    	return analysisMapper.findByDiaryId(dId);
    }
}
