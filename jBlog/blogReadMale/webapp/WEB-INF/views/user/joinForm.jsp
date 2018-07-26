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
                <!-- id input에 onkeydown="inputIdChk()" 추가 -->
                <input type="text" class="form-control" name="id" id="exampleInputName" onkeydown="inputIdChk()" aria-describedby="nameHelp" placeholder="Enter ID"> 
              </div>
             <div class="col-md-6">
                <label for="exampleInputLastName">&nbsp; </label>
                <!-- <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="중복검사"> -->
              	<br/>
              	<input type="button" class="btn btn-default" value="중복체크" id="btnIdCheck"><span id="result">&nbsp;</span><br/>
              	<input type="hidden" name="idDuplication" id="idDuplication" value="idUncheck">
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">이름 </label>
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
          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/user/login">Login Page</a>
          <a class="d-block small" href="${pageContext.request.contextPath }/main">home</a>
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
	/* 중복체크 검사 */
	var flag = 0;
	var checkedId;
	
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
			return false;
		}
		if(jForm.chkBox.checked == false) {
			alert("약관에 동의해주세요!")
			return false;
		}
		//비밀번호를 동일하게 입력하지 않았을 시		
		if(jForm.password.value != jForm.password2.value) {
			alert('비밀번호를 동일하게 입력해주세요!');
			jForm.password2.focus()
			return false;
		}
		//아이디 중복체크를 하지 않았을시
		if(jForm.idDuplication.value != "idCheck") {
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		
		//아이디에 공백 사용하지 않기
        if (jForm.id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            jForm.id.focus()
            jForm.id.select()
            return false;
        }
	}
	//아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
	//중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 떄 다시 중복체크를 하도록 한다.
	function inputIdChk() {
		var jForm = document.joinForm;
		jForm.idDuplication.value="idUncheck";
	}
	
	$(document).ready(function() {
		$("#btnIdCheck").on("click",function() {
			//alert("아이디 체크");
			//console.log($("#exampleInputName").val());
			var msg='';
			var flag=false;
			
			id=$("#exampleInputName").val();
			if(id=='') {
				alert("아이디를 입력하세요!");
				return false;
			}
			console.log(id);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/user/checkId",
				type: "get",
				data: {id:id},
				dataType: "json",
				success: function(result) {
					//alert("연결성공!");
					console.log("result:" +result);
					if(result.data != true) {
						msg="&nbsp;사용 가능한 아이디입니다.";
						chkMsg="idCheck";				//중복검사 완료
						$("#idDuplication").val(chkMsg)	//체크완료 값 넣기
						$("#result").html(msg);
					}else{
						msg="&nbsp;중복된 아이디입니다.";
						$("#result").html(msg);
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

