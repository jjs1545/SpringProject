<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/board.css" />
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<table class="tbl-ex">
				<tr>	
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성자</th>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.no }</td>
						<td>${vo.title }</td>
						<td>${vo.userName }</td>
						<td>${vo.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<div class="bottom">
				<c:if test="${authUser != null}">
					<a href="${pageContext.request.contextPath}/board/write">게시물 작성</a>
				</c:if>
			</div>
		</div>
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>