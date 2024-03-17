<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function deleteNews(news_idx) {
        var url = 'company_news_Delete.do?news_idx=' + news_idx;
        window.location.href = url;
    }

    function updateNews(news_idx) {
    	var url = 'company_news_UpdateForm.do?news_idx=' + news_idx;
        window.location.href = url;
    }
</script>
<style>
#left {
	width: 200px;
	height: 600px;
	float: left;
	border-right: 2px solid darkblue;
	margin-left: 50px;
}

#right {
	width: 900px;
	height: 600px;
	margin-left: 330px;
}

#bt {
	width: 180px;
	height: 40px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<div id="left">
			<button id="bt" type="button" class="btn btn-outline-primary"
				onclick="location.href='company_news_Writeform.do';">글 작성</button>
			<div class="mt-3">
				<a href="company_news_List.do">회사소식</a> <br> 경조사
			</div>
		</div>
		<div id="right">
			<div class="container">
				<div class="mt-5 mb-2">
					<span class="h4">회사소식&gt;&gt;${dto.news_idx }번 게시글</span>
				</div>
				<table width="1000" cellspacing="0" class="table">
					<tr align="center">
						<th class="table-primary">번호</th>
						<td>${dto.news_idx }</td>
						<th class="table-primary">작성일</th>
						<td>${dto.news_writedate }</td>
						<th class="table-primary">작성자</th>
						<td>${dto.news_writer }</td>
					</tr>
					<tr>
						<th class="text-center table-primary">제목</th>
						<td colspan="6">${dto.news_title }</td>
					</tr>
					<tr height="400">
						<td colspan="6" align="left" valign="top">${dto.news_content }</td>
					</tr>
				</table>

				<div class="d-flex justify-content-center">
					<button id="bt" type="button" class="btn btn-outline-primary"
						onclick="location.href='company_news_List.do';">목록</button>
					&nbsp; &nbsp;
					<button id="bt" type="button" class="btn btn-outline-success" onclick="updateNews(${dto.news_idx});">수정</button>
					&nbsp; &nbsp;
					<button id="bt" type="button" class="btn btn-outline-danger" onclick="deleteNews(${dto.news_idx});">삭제</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>