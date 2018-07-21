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
  <title>로그인</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath }/css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">로그인</div>
      <div class="card-body">
        <form method="post" name="loginForm" action="${pageContext.request.contextPath}/user/login" onsubmit="return doCheck()">
          <div class="form-group">
            <label for="exampleInputEmail1">아이디</label>
            <input class="form-control" name="id" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter ID">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">비밀번호</label>
            <input class="form-control" name="password" id="exampleInputPassword1" type="password" placeholder="Enter Password">
          </div>
          <input type="submit" class="btn btn-primary btn-block" value="Login">
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath }/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
	<script language="javascript" type="text/javascript">
		/* 회원가입 유효성 검사 */
	
		function isNull(obj, msg) {
			if(obj.value == "") {
				alert(msg);
				obj.focus();
				return true;
			}
			return false;
		}
		function doCheck() {
			var jForm = document.loginForm;
			
			if(isNull(jForm.id, '아이디를 입력해주세요!')) {
				return false;
			}
	
			if(isNull(jForm.password, '비밀번호를 입력해주세요!')) {
				return false
			}
			
		}
	</script>	
</html>	
	
	
	
	
	