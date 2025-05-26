<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h2 class="card-title mb-4">📝 日記詳細</h2>

            <c:choose>
                <c:when test="${not empty diary}">
                    <p><strong>📅 日付:</strong> ${diary.date}</p>
                    <p><strong>📌 タイトル:</strong> ${diary.title}</p>
                    <hr>
                    <p>${diary.content}</p>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-warning">
                        この日に投稿された日記はありません。
                    </div>
                </c:otherwise>
            </c:choose>
            
            <div class="card mt-3">
			  <div class="card-header">🧠 AI 分析結果</div>
			  <div class="card-body">
			    <p><strong>要約:</strong> ${diaryAnalysis.summary}</p>
			    <p><strong>感情:</strong> ${diaryAnalysis.emotion}</p>
			    <p><strong>天気:</strong> ${diaryAnalysis.weatherStyle}</p>
			  </div>
			</div>

            <div class="mt-4">
                <a href="/dashboard" class="btn btn-outline-primary">← カレンダーに戻る</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
