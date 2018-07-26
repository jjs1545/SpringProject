<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/user/join">Register an Account</a>
          <a class="d-block small" href="${pageContext.request.contextPath }/main">Back to Home?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath }/vendor/jquery-easing/jquery.easing.min.js"></script> --%>
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
        <form method="post" name="loginForm">
          <div class="form-group">
            <label for="exampleInputEmail1">아이디</label>
            <input class="form-control" name="id" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter ID">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">비밀번호</label>
            <input class="form-control" name="password" id="exampleInputPassword1" type="password" placeholder="Enter Password">
          </div>
          <div id="result" class="form-group">
          </div>
        </form>
        <button id="chk" class="btn btn-primary btn-block">Login</button>
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/user/join">Register an Account</a>
          <a class="d-block small" href="${pageContext.request.contextPath }/main">Back to Home?</a>
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
			
		
		$(document).on("click","#chk",function() {
				//alert("아이디 체크");
				
				var id=$("#exampleInputEmail1").val();
				var password=$("#exampleInputPassword1").val();
				
				//alert("id:"+id+"password:"+password);
				
				$.ajax({
					url:action="${pageContext.request.contextPath}/user/login",
					type: "post",
					data: {"id":id, "password":password},
					dataType: "json",
					success: function(result) {
						//alert("연결성공!")
						if(!result.result) {
							var msg='';
							msg+="<center><p>로그인실패</p></center>";
							msg+="<center><p>아이디/패스워드를 확인해주세요</p></center>";
							$("#result").html(msg);
						}
						else{
							location.href="${ pageContext.request.contextPath}/main"
						}
					},
					error: function(error) {
						console.err(error);
					}
				});
			});
	</script>	
</html>	
<%-- $(document).ready(function() {
	$('#login').on("click", function() {
		id = $("#id").val();
		password = $("#password").val();
		
		$.ajax({
			url: "${ pageContext.request.contextPath}/user/login",
			type:"post",
			data:{id:id, password:password},
			dataType: "json",
			success: function(result) {
				if(!result) {
					document.getElementById("message").innerHTML="<p>로그인실패</p><p>아이디/패스워드를 확인해주세요</p>"
				}
				else{
					location.href="${ pageContext.request.contextPath}/main"
				}
			}
		});
	});
	
}) --%>
	
	
	
	