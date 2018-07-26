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
<title>회원가입</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/main.css" />
 <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath }/css/sb-admin.css" rel="stylesheet">

</head>
<body class="bg-dark">
	  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">회원가입</div>
      <div class="card-body">
       <form method="post" name="joinForm" action="${pageContext.request.contextPath }/user/join"
       					onsubmit="return doCheck()">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">아이디</label>
                <input class="form-control" name="id" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter ID">
              </div>
             <div class="col-md-6">
                <label for="exampleInputLastName"> 아이디 중복 체크 </label>
                <!-- <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="중복검사"> -->
              	<br/>
              	<input type="button" class="btn btn-default" value="중복체크" id="btnIdCheck"><br/>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">이름</label>
            <input class="form-control" name="name" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter name">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">비밀번호</label>
                <input class="form-control" id="exampleInputPassword1"  name="password" type="password" placeholder="Password">
              </div>
            <div class="col-md-6">
                <label for="exampleConfirmPassword">비밀번호 확인</label>
                <input class="form-control" id="exampleConfirmPassword" name="password2" type="password" placeholder="Confirm password">
            </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" name="chkBox" type="checkbox">서비스 약관에 동의합니다.</label>
            </div>
          </div>
          <button type="submit" class="btn btn-primary btn-block">회원가입</button>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
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
		var jForm = document.joinForm;
		
		if(isNull(jForm.id, '아이디를 입력해주세요!')) {
			return false;
		}
		if(isNull(jForm.name, '이름을(를) 입력해주세요!')) {
			return false;
		}
		if(isNull(jForm.password, '비밀번호를 입력해주세요!')) {
			return false
		}
		if(isNull(jForm.password2, '비밀번호를 확인해주세요!')) {
			return false
		}
		if(jForm.chkBox.checked == false) {
			alert("약관에 동의해주세요!")
			return false
		}
	}
	
	$(document).ready(function() {
		$("#btnIdCheck").on("click",function() {
			alert("아이디 체크");
			console.log($("#exampleInputName").val());
			
			id=$("#exampleInputName").val();
			console.log(id);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/user/checkId",
				type: "get",
				data: {id:id},
				dataType: "json",
				success: function(result) {
					alert("연결성공!");
					console.log("result:" +result);
					if(result.data != true) {
						alert("사용 가능한 아이디입니다.");
					}else{
						alert("이미 사용하고 있는 아이디입니다.");
					}
				},
				error: function(error) {
					console.err(error);
				}
			});
		});
	});
</script>
</html> 

