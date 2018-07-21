<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>
	<c:import url="/WEB-INF/views/includes/header.jsp" />
  </head>

  <body>
  	 <!-- navigation -->
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
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/basic">내 블로그 관리</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
			</c:otherwise>
		 </c:choose>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
      <ol class="breadcrumb">
      	<c:choose>
      		<c:when test="${empty authUser }">
	        	<li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/user/login">킁</a></li>
	        </c:when>
	        <c:otherwise>
	        	<c:if test="${vo.USERS_NO eq authUser.no}">
		 		<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">누르지마</a></li>
		        </c:if>
		        <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
	        </c:otherwise>
        </c:choose>
      </ol>
      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">
        <small>등록된 글이 없습니다.</small>
      </h1>
       <%-- <c:choose>
        	<c:when test="${empty authUser}">
        		<a class="navbar-brand" href="${pageContext.request.contextPath }/main">JUSIN 블로그</a>
			</c:when>
			<c:otherwise>
        		<a class="navbar-brand" href="${pageContext.request.contextPath }/main">${authUser.name }님 안녕하세요 !</a>
			</c:otherwise>
        </c:choose> --%>
      <div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100 text-center">
           <!--  <img class="card-img-top" src="http://placehold.it/750x450" alt="">
            <div class="card-body">
              <h4 class="card-title">Team Member1</h4>
              <h6 class="card-subtitle mb-2 text-muted">Position</h6>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p>
            </div>
            <div class="card-footer">
              <a href="#">name@example.com</a>
            </div> -->
          </div>
        </div>
        <!-- <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="http://placehold.it/750x450" alt="">
            <div class="card-body">
              <h4 class="card-title">Team Member2</h4>
              <h6 class="card-subtitle mb-2 text-muted">Position</h6>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p>
            </div>
            <div class="card-footer">
              <a href="#">name@example.com</a>
            </div>
          </div>
        </div> -->
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <!-- <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/${vo.logo}" alt="">
            <div class="card-body">
              <h4 class="card-title">카테고리</h4>
              <h6 class="card-subtitle mb-2 text-muted">미분류</h6>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p>
            </div>
            <div class="card-footer">
              <a href="#">name@example.com</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

      <!-- Our Customers -->
      <h2>My Blog</h2>
      <div class="row">
        <div class="col-lg-2 col-sm-4 mb-4">
          <img class="img-fluid" src="${pageContext.request.contextPath }/img/first.jpg" alt="">
        </div>
        <div class="col-lg-2 col-sm-4 mb-4">
           <img class="img-fluid" src="${pageContext.request.contextPath }/img/earth.jpg" alt="">
        </div>
        <div class="col-lg-2 col-sm-4 mb-4">
          <img class="img-fluid" src="${pageContext.request.contextPath }/img/wallpaper02.jpg" alt="">
        </div>
        <div class="col-lg-2 col-sm-4 mb-4">
          <img class="img-fluid" src="${pageContext.request.contextPath }/img/third.jpg" alt="">
        </div>
        <div class="col-lg-2 col-sm-4 mb-4">
          <img class="img-fluid" src="${pageContext.request.contextPath }/img/wallpaper01.jpg" alt="">
        </div>
        <div class="col-lg-2 col-sm-4 mb-4">
          <img class="img-fluid" src="${pageContext.request.contextPath }/img/wallpaper03.jpg" alt="">
        </div>
      </div>
      <!-- /.row -->

    </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- footer -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
