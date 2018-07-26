<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        	<a class="navbar-brand" href="${pageContext.request.contextPath }/main">${vo.title }</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          <c:choose>
            <c:when test="${empty authUser }">
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath }/user/join">회원가입</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath }/user/login">로그인</a>
	            </li>
            </c:when>
            <c:otherwise>
            		<li class="nav-item">
		              <a class="nav-link" href="${pageContext.request.contextPath }/main">HOME</a>
		            </li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/${authUser.id}">BLOG</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
			</c:otherwise>
		 </c:choose>
          </ul>
        </div>
      </div>
    </nav>
</body>
</html>