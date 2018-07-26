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
      	<li>가입 성공!</li>
     </ol>
     <div class="row">
       <div class="col-lg-8 mb-8">
         <div class="card h-100 text-center" >
           <div id="status"></div>
           <div id="image">
           </div>
           <div class="card-body">
           	 <P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
             <p class="card-text">축하합니다 !
             					    가입이 완료되었습니다.
             					    로그인을 해주세요!
             </p>
             <P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P><P>&nbsp;</P>
           </div>
           <div class="card-footer">
             <button type="submit"  class="btn btn-default">회원가입완료!</button>
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
   </div>
   <!-- /.container -->

   <!-- footer -->
   <c:import url="/WEB-INF/views/includes/footer.jsp"/>


   <!-- Bootstrap core JavaScript -->
   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
