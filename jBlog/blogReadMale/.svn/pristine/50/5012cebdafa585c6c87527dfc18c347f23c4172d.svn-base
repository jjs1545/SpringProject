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
        <small>등록된 글이 없습니다.</small>
      </h1>
      <ol class="breadcrumb">
	        	<li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
		 		<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
		        <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
      </ol>
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
          <table border="1">
          	<thead>
          		<tr>
          			<th>번호</th>
          			<th>카테고리명</th>
          			<th>포스트 수</th>
          			<th>설명</th>
          			<th>삭제</th>
          		</tr>
          	</thead>
          	<tbody>
          		<tr>
	          		<td></td>
	          		<td></td>
	          		<td></td>
	          		<td></td>
	          		<td></td>
          		</tr>
          	</tbody>
          </table>
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
            <img class="card-img-top" src="${pageContext.request.contextPath }/img/blog.png" alt="">
            <div class="card-body">
              <h4 class="card-title">새로운 카테고리 추가</h4>
              <br/>
              <br/>
              <h6 class="card-subtitle mb-2 text-muted" align="left">카테고리명: </h6>
              <h6 class="card-subtitle mb-2 text-muted"><input type="text" class="form-control" name="cTitle"></h6>
              <h6 class="card-subtitle mb-2 text-muted" align="left">설명: </h6>
              <h6 class="card-subtitle mb-2 text-muted"><input type="text" class="form-control" name="explain"></h6>
              <h6 class="card-subtitle mb-2 text-muted"></h6><br/>
              <p class="card-text">JS BLOG.</p>
            </div>
            <div class="card-footer">
              <a href="#">카테고리 추가</a>
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
