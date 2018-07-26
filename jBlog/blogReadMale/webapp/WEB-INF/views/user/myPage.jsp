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
      	<li>마이페이지</li>
     </ol>
     <div class="row">
       <div class="col-lg-8 mb-8">
         <div class="card h-100 text-center" >
           <div id="status"></div>
           <div id="image">
           </div>
           <div class="card-body">
           	 <P>&nbsp;</P><P>&nbsp;</P>
             <c:if test="${ !empty authUser }">
             	 <p class="card-text" align="left">아이디: </p>
             	 <input type="text" class="form-control" id="id" value="${user.id }">
             	 <P>&nbsp;</P>
             	 <p class="card-text" align="left">이름: </p>
             	 <input type="text" class="form-control" id="id" value="${user.name }">
             	 <P>&nbsp;</P>
             	 <p class="card-text" align="left">비밀번호: </p>
             	 <input type="text" class="form-control" id="id" value="${user.password }">
             	 <P>&nbsp;</P>
             	 <p class="card-text" align="left">가입날짜: </p>
             	 <input type="text" class="form-control" id="id" value="${user.join_date }">
             </c:if>
             <P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
           </div>
           <div class="card-footer">
             <button type="submit"  class="btn btn-default">마이페이지</button>
           </div>
         </div>
       </div>
       <div class="col-lg-4 mb-4">
         <div class="card h-100 text-center">
           <!-- <img class="card-img-top" src="http://placehold.it/750x450" alt=""> -->
           <img class="card-img-top" src="${pageContext.request.contextPath }/img/blog3.png" alt="">
           <form name="myPageForm" method="POST" action="${pageContext.request.contextPath}/user/modify/action">
           <div class="card-body">
             <h4 class="card-title">회원 정보 수정하기</h4>
             <p>&nbsp;</p>
             <br/>
             <br/>
             <input type="hidden" name="user_no" value="${authUser.no }">
             <h6 class="card-subtitle mb-2 text-muted" align="left">이름: </h6>
             <h6 class="card-subtitle mb-2 text-muted"><input type="text" class="form-control" id="name" name="name" value="${user.name }"></h6>
             <h6 class="card-subtitle mb-2 text-muted" align="left">비밀번호: </h6>
             <h6 class="card-subtitle mb-2 text-muted"><input type="text" class="form-control" id="password" name="password"></h6>
             <h6 class="card-subtitle mb-2 text-muted"></h6><br/>
             <input type="hidden" value="${vo.no}" id="bno" name="bno">
             <p class="card-text">JS BLOG.</p>
           </div>
           <div class="card-footer">
             <button type="submit" id="btn" class="btn btn-default">변경</button>
           </div>
           </form>
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
   </div>
   <!-- /.container -->

   <!-- footer -->
   <c:import url="/WEB-INF/views/includes/footer.jsp"/>


   <!-- Bootstrap core JavaScript -->
   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
