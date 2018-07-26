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
      <!-- <h1 class="mt-4 mb-3">
        <small>등록된 글이 없습니다.</small>
      </h1> -->
      <ol class="breadcrumb">
       	<li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic" style="color:black">기본설정</a></li>
 		<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category" style="color:black">카테고리</a></li>
        <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm" style="color:black">글작성</a></li>
      </ol>
      <div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100 text-center" >
          <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/blog/update">
            <div id="status"></div>
            <div id="image">
            <c:choose>
	        	<c:when test="${ empty result }">
	           		<!-- <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
	           		<img class="card-img-top" src="${pageContext.request.contextPath}/images/${vo.logo}"/>
	           	</c:when>
				<c:otherwise>
	        		<img class="card-img-top" src="${pageContext.request.contextPath}/images/${vo.logo}"/>
				</c:otherwise>
            </c:choose>
            </div>
            <div class="card-body">
              <h4 class="card-title">로고 이미지</h4>
              <input type="file" name="file" class="card-title">
              <input type="hidden" name="logo" value="${vo.logo}">
              <h6 class="card-subtitle mb-2 text-muted" align="left">블로그 제목 :<br/>
              <input type="text" class="form-control" name="title" value="${vo.title }"></h6>
             <!--  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p> -->
            </div>
            <div class="card-footer">
              <button type="submit"  class="btn btn-default">기본설정변경</button>
            </div>
            </form> 
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
        <!-- <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="http://placehold.it/750x450" alt="">
            <div class="card-body">
              <h4 class="card-title">카테고리</h4>
              <h6 class="card-subtitle mb-2 text-muted">미분류</h6>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Possimus aut mollitia eum ipsum fugiat odio officiis odit.</p>
            </div>
            <div class="card-footer">
              <a href="#">name@example.com</a>
            </div>
          </div>
        </div> -->
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
    </div>
    <!-- /.container -->

    <!-- footer -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
<script>
	var upload = document.getElementsByTagName('input')[0],
	    image = document.getElementById('image'),
	    state = document.getElementById('status');
	
	if (typeof window.FileReader === 'undefined') {
	  state.className = 'fail';
	} else {
	  state.className = 'success';
	 /*  state.innerHTML = 'File API & FileReader available'; */
	}
	 
	upload.onchange = function (e) {
	  e.preventDefault();
	
	  var file = upload.files[0],
	      reader = new FileReader();
	  reader.onload = function (event) {
	    var img = new Image();
	    img.src = event.target.result;
	    if (img.width > 560) { // holder width
	      img.width = 560;
	    }
	    image.innerHTML = '';
	    image.appendChild(img);
	  };
	  reader.readAsDataURL(file);
	
	  return false;
};
</script>
</html>
