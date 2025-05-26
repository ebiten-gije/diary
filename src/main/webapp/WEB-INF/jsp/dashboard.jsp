<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty message}">
    <div class="alert alert-success">${message}</div>
</c:if>

<div class="container mt-4">
    <h2 class="mb-4">📅 マイカレンダー</h2>
    
    <!-- 달력이 들어갈 곳 -->
    <div id="calendar"></div>
</div>

<!-- FullCalendar CDN 추가 -->
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.17/index.global.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/daygrid@6.1.17/index.global.min.js'></script>

<!-- 달력 렌더링 스크립트 -->
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            locale: 'ja', // 일본어로 달력 표시
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: ''
            },
            events: [], // 여기에 Ajax로 작성된 일기 날짜 데이터를 넣을 예정
            eventClick: function(info) {
                const dateStr = info.event.startStr; // 클릭한 이벤트의 날짜
                console.log(dateStr);
                window.location.href = '/diary/' + dateStr;
            }
        });

        calendar.render();

        // 작성된 일기 날짜를 불러오는 Ajax
        fetch('/api/diary/month?userId=1&year=2025&month=5') // 실제 유저 ID는 동적으로 변경
            .then(response => response.json())
            .then(data => {
            	console.log("받은 데이터:", data);
                const events = data.map(date => ({
                    title: '✔',
                    start: date,
                    color: '#28a745' // 작성된 날은 초록색
                }));
                calendar.addEventSource(events);
            });
    });
</script>

<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>