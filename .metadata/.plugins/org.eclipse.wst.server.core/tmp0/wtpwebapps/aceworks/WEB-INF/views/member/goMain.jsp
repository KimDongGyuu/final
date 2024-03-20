<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.getName()}의 마이페이지</title>
</head>
<body>

<h5>${dto.getName()} 님 환영합니다 | <a href="logout.do">로그아웃</a></h5>

<a href="company_news_List.do?com_idx=${dto.getCom_idx()}">회사소식</a>

<a href="company_event_List.do?com_idx=${dto.getCom_idx()}">경조사</a>
<a href="#">결재문서</a>
<a href="#">스케줄</a>
<a href="#">인사관리</a>
<c:if test="${dto.rank_num == 2 || dto.rank_num == 1}">
	<a href="#">기업관리</a>
</c:if>

</body>
</html>