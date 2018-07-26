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
			<form class="board-form" method="post" action="${pageContext.request.contextPath}/board/write">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글쓰기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td><textarea name="content"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="작성"></td>
					</tr>
				</table>
			</form>
		</div>
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>