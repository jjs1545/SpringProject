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
	<c:import url="/WEB-INF/views/includes/navigation2.jsp"/>
    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">
        <small>JS BLOG 블로그</small>
      </h1>
      <ol class="breadcrumb">
			<li>&nbsp;</li>
      </ol>
	       <h1>검색 결과가 없습니다.</h1>
      <div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100 text-center">
            <form name="writeForm" method="post" action="${pageContext.request.contextPath}/post/write" onsubmit="return doCheck()">
            <div class="card-body">
              <c:forEach items="${list}" var="list" varStatus="status">
              	<a href="${pageContext.request.contextPath}/${list.id}">
		        	<img src="${pageContext.request.contextPath}/images/${list.logo}" style="width:150px; heigth:150px; float:left"/>
		        </a>
	        	<p class="card-title" style="float:left;">&nbsp; ${list.name }님의 블로그</p>
	        	<p>&nbsp;</p>
	        	<p class="card-title" style="float:left;">&nbsp; ${list.title}</p>
	          </c:forEach>
              <!-- 카테고리 리스트 가져오기 -->
              <br/><br/><br/>
            </div>
            <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
            <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
            <div class="card-footer">
            </div>
           </form>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <!-- <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
            <img class="card-img-top" src="${pageContext.request.contextPath }/img/blog3.png" alt="">
            <p>&nbsp;</p>
            <div class="card-body">
              <h4 class="card-title">JS BLOG</h4>
              <h6 class="card-subtitle mb-2 text-muted">&nbsp;</h6>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p class="card-text">블로그를 검색하세요.</p>
              <p class="card-text">&nbsp;</p>
            </div>
            <div class="card-footer">
              <a href="#">blogReadMale</a>
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

    <!-- /.container -->

    <!-- footer -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>


</html>
