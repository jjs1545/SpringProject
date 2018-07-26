<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<!-- 페이지 일반 정보 -->
<h2>Paging Example</h2>
<h4>Page Status</h4>
<p>Current Page: ${currPage }</p>
<p>Max Pages: ${maxPage }</p>
<p>Logs Per Page: ${logsPerPage }</p>
<hr>
<h4>Content List</h4>
<ul>
<c:forEach items="${contents }" var="vo">
	<li>${vo.id } - ${vo.log }</li>
</c:forEach>
</ul>
<hr>
<h4>Navigation</h4>
<!-- 이전 페이지 처리 -->
<ul>
<c:choose>
	<c:when test="${currPage > 1 }">
	<li><a href="?page=${currPage - 1 }">이전 페이지</a></li>
	</c:when>
	<c:otherwise>
	<li>이전 페이지 없음</li>
	</c:otherwise>
</c:choose>
<!-- 게시물 목록의 처리 -->
<c:forEach begin="${navStartPage }" end="${navStartPage + navPageCount - 1}" var="pageIdx">
	<c:if test="${pageIdx <= maxPage }">
		<!-- 네비게이션의 페이지가 현재페이지이면 링크는 표시하지 않음 -->
		<c:choose>
			<c:when test="${currPage == pageIdx }">
			<li><b>${pageIdx }</b></li>
			</c:when>
			<c:otherwise>
			<li><a href="?page=${pageIdx}">${pageIdx }</a></li>
			</c:otherwise>
		</c:choose>
	</c:if>
</c:forEach>
<!-- 다음 페이지 처리 -->
<c:choose>
	<c:when test="${currPage < maxPage }">
	<li><a href="?page=${currPage + 1 }">다음 페이지</a></li>
	</c:when>
	<c:otherwise>
	<li>다음 페이지 없음</li>
	</c:otherwise>
</c:choose>
</ul>
</body>
</html>
