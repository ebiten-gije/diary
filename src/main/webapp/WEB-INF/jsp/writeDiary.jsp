<%-- /WEB-INF/jsp/writeDiary.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }
    input[type="date"],
    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    textarea {
        resize: vertical;
        min-height: 150px;
    }
    .card {
	    background-color: #fff;
	    border: 1px solid #ddd;
	    border-radius: 8px;
	}

</style>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card p-4 shadow-sm">
                <h2 class="mb-4">日記を書く</h2>

                <form action="/write" method="post">
                    <div class="form-group">
                        <label for="diaryDate">日付:</label>
                        <input type="date" id="diaryDate" name="diaryDate" value="${currentDate}" required>
                    </div>
                    <div class="form-group">
                        <label for="title">タイトル:</label>
                        <input type="text" id="title" name="title" placeholder="今日あったこと、感じたことなど" value="${param.title != null ? param.title : ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="content">本文:</label>
                        <textarea id="content" name="content" placeholder="今日あった出来事やあなたの感情を自由に書きましょう。" required>${param.content != null ? param.content : ''}</textarea>
                    </div>
                    <button type="submit" class="btn btn-success w-100">日記を投稿</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>