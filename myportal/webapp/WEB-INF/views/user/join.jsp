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
<title>Template</title>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/user.css" />
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<form:form method="post" id="join-form" modelAttribute="userVo" action="${pageContext.request.contextPath}/user/join">
					<label for="name">이름:</label>
					<!-- <input type="text" name="name"> -->
					<form:input path="name"/>
					<%-- <form:errors path="name" /> --%>
					<c:if test="${errors.hasFieldErrors('name')}">
						<strong>
						<spring:message code="${errors.getFieldError('name').codes[0]}" text="${errors.getFieldError('name').defaultMessage }"/>
						</strong>
					</c:if>
					<p></p>
					<label for="email">이메일:</label>
					<!-- <input type="text" name="email" id="email"> -->
					<form:input path="email"/>
					<form:errors path="email" />
					<input type="button" value="중복체크" id="btnEmailCheck">
 					<p></p>
					<label for="password">비밀번호:</label>
					<!-- <input type="password" name="password"> -->
					<form:password path="password"/>
					<form:errors path="password" />
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <!-- <input type="radio" name="gender" value="FEMALE"> -->
						<form:radiobutton path="gender" value="FEMALE"/>
						<label>남</label> <!-- <input type="radio" name="gender" value="MALE"> -->
						<form:radiobutton path="gender" value="MALE"/>
					</fieldset>
					<input type="submit" value="가입하기">
				</form:form>
			</div>
		</div>
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		$("#btnEmailCheck").on("click",function() {
			//alert("이메일 체크");
			//console.log($("#email").val());
			email=$("#email").val();
			console.log(email);
			
			$.ajax({
				url: "${pageContext.request.contextPath}/user/checkemail",
				type: "get",
				data: {email:email},
				dataType: "json",
				success: function(result){
					console.log(result);
					
					if(result.data == true) {
						alert("이미 가입되어 있는 이메일입니다.");
					} else {
						alert("사용 가능한 이메일입니다.");
					}
				},
				error: function(xhr, status, error) {
					console.err(status + ":" + error);					
				}
			});
		});
	});
</script>
</html>