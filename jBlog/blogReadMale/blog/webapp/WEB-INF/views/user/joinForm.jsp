<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hee </title>
</head>
<style>
	.form-group {
		padding: 50px 300px 0 450px;
	}
	
</style>
<body>
<div id="header">
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
</div>
	<div id="content" align="center">
		<h2>회원가입</h2>
		<form class="form-horizontal" name="joinForm" action="${ pageContext.request.contextPath }/user/join" method="post">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">ID</label>
				<div class="col-sm-6">
					<input type="text" name="id" id="id" class="form-control" placeholder="아이디를 입력해주세요.">
					<input type="button" class="btn btn default" value="중복체크 " id="btnIdCheck" style="margin-left:400px; margin-top:-35px;">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-6">
					<input type="text" name="name" id="name" class="form-control" placeholder="이름을 입력해주세요.">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-6">
					<input type="password" name="password" id="password" class="form-control" placeholder="비밀번호를 입력해주세요.">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Password Check</label>
				<div class="col-sm-6">
					<input type="password" name="pwcheck" id="pwcheck" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요.">
				</div>
			</div>
			<div class="checkbox">
			약관동의 <br/>
				<label>
					<input type="checkbox"> 서비스 약관에 동의합니다.
				</label>
			</div>
			<input type="submit" value="회원가입" class="btn btn-primary btn-block" style="margin:30px; width:300px">
		</form>
		</div>
</body>
</html>