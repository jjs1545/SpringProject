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
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/guestbook.css" />
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="guestbook">
			<!-- 입력 폼 -->
			<form method="post" action="${pageContext.request.contextPath }/guestbook/insert">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content"></textarea>
						</td>
					</tr>				
					<tr>
						<td colspan="4"><input type="submit" value="작성"></td>
					</tr>
				</table>
			</form>
			<ul>
				<c:forEach items="${list}" var="vo" varStatus="status">
				<li>
					<table>
						<tr>
							<td>${vo.no }</td>
							<td>${vo.name }</td>
							<td>${vo.regdate }</td>
							<td><a href="${pageContext.request.contextPath }">삭제</a></td>
						</tr>
						<tr>
							<td colspan="4">
								${fn:replace(vo.content, newLine, "<br>") } <!-- 개행 문자 -->
							</td>
						</tr>
					</table>
				</li>
				</c:forEach>
			</ul>
			</div>
		</div>
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>