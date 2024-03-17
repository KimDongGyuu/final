<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#left {
	width: 200px;
	height: 600px;
	float: left;
	border-right: 2px solid black;
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

#Sbt {
	width: 70px;
	height: 45px;
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
<div class="mt-3"><a href="company_news_List.do">회사소식</a> <br> 경조사 <br><a href="fileUploadForm.do">파일업로드</a></div>
		</div>
		<div id="right">
		<div class="mt-5 mb-2"><span class="h4">게시판 &gt;&gt; 회사소식 &gt;&gt; 검색결과</span></div>
		
<div class="mt-2 d-flex gap-2 justify-content-end">
    <form action="company_newsSearch.do">
        <input type="text" id="searchKeyword" name="keyword" placeholder="검색어를 입력하세요." style="width:70%; height: 35px;">
        <button id="Sbt" type="submit" class="btn btn btn-primary">검색</button>
    </form>
</div>
			<table width="1000" cellspacing="0" class="table table-hover">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">등록자</th>
						<th scope="col">등록일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>

				<tbody class="table-group-divider">
					<c:if test="${empty lists }">
						<tr>
							<td colspan="5" align="center">등록된 게시물이 없습니다</td>
						</tr>
					</c:if>

					<c:forEach var="dto" items="${lists }">
						<tr class="text-center">
							<th scope="row">${dto.news_idx }</th>
							<c:url var="company_newsContentUrl"
								value="company_news_Content.do">
								<c:param name="news_idx">${dto.news_idx }</c:param>
							</c:url>
							<td><a href="${company_newsContentUrl }">${dto.news_title }</a></td>
							<td>${dto.news_writer }</td>
							<td>${dto.news_writedate }</td>
							<td>${dto.news_readnum }</td>
						</tr>
					</c:forEach>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="5" align="center">페이징</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
</html>