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
	<!-- Add icon library -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		.btnToggle {
		    background-color: lightgray;
		    border: none;
		    color: white;
		    padding: 12px 16px;
		    font-size: 16px;
		    cursor: pointer;
		}
		
		/* Darker background on mouse-over */
		.btn:hover {
		    background-color: RoyalBlue;
		}
	</style>
</head>

<body>
  	<!-- Map 선언 -->
	<%-- <c:set var="map" value="${map }" /> --%>
	${map.title }
  	 <!-- navigation -->
	 <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        	<a class="navbar-brand" href="${pageContext.request.contextPath }/main">${vo.title }</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          <c:choose>
            <c:when test="${empty authUser }">
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath }/user/join">회원가입</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="${pageContext.request.contextPath }/user/login">로그인</a>
	            </li>
            </c:when>
            <c:otherwise>
            		<li class="nav-item">
		              <a class="nav-link" href="${pageContext.request.contextPath }/main">HOME</a>
		            </li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/basic">내 블로그 관리</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
			</c:otherwise>
		 </c:choose>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
      <ol class="breadcrumb">
		<li>&nbsp;</li>
      </ol>
      <div class="row">
        <div class="col-lg-8 mb-8">
          <div class="card h-100 text-center">
          	<c:choose>
	      	  <c:when test="${empty post}">
			      <h1 class="mt-4 mb-3">
			        <small>등록된 글이 없습니다.</small>
			      </h1>
		      </c:when>
		      <c:otherwise>
			      <h4 class="card-title" align="left">${post.title}</h4>
			      <p class="card-text" align="left">${post.content}</p>
	          </c:otherwise>
	       </c:choose>
	       <p id="postNo" style="display:none;">${post.no }</p>
	       <p>&nbsp;</p><p>&nbsp;</p>
	       <p>&nbsp;</p><p>&nbsp;</p>
		   <p align="left"><button type="submit" class="btnToggle" id="cWrite">댓글 쓰기</button></p>
		   <p align="right"><button type="submit" class="btnToggle" id="cList">댓글 목록</button></p>
				<div id="commentForm" style="display: none">
					<c:choose>
						<c:when test="${!empty authUser }">
							<table class="table table-bordered">
								<tr>
									<td id="userName">${authUser.name}</td>
									<td><input type="text" class="form-control" id="content" name="content" style="width:100%;"></td>
									<td colspan="4"><button type="submit" id="commentWrite" class="btn btn-default">작성</button></td>
								</tr>
							</table>
						</c:when>
						<c:otherwise>
							<p>로그인 후 작성이 가능합니다</p>
						</c:otherwise>
					</c:choose>
				</div>
			
		  <!--  <p>&nbsp;</p><p>&nbsp;</p>
	       <p>&nbsp;</p><p>&nbsp;</p> -->
	       
	       <div id="commentForm" style="display: none">
					<c:choose>
						<c:when test="${!empty authUser }">
							<table class="table table-bordered">
								<tr>
									<td id="userName">${authUser.name}</td>
									<td><input type="text" class="form-control" id="content" name="content" style="width:100%;"></td>
									<td colspan="4"><button type="submit" id="commentWrite" class="btn btn-default">작성</button></td>
								</tr>
							</table>
						</c:when>
						<c:otherwise>
							<p>로그인 후 작성이 가능합니다</p>
						</c:otherwise>
					</c:choose>
				</div>
				
	       <!-- comment List 테이블 (댓글)-->
			<div id="commentList" style="display: none">
				<table class="table table-bordered">
					<tbody>
					<c:forEach items="${commentList}" var="cList" varStatus="status">
								<tr>
									<td id="comment_no"style="display:none">${cList.no}</td>
									<td>${cList.name }</td>
									<td>${cList.content }</td>
									<td>${cList.reg_date}</td>
									<c:if test="${authUser.name eq cList.name}">
										<td>&nbsp;<button id="deleteBtn" class="btn btn-default">x</button></td>
									</c:if>
								</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100 text-center">
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/${vo.logo}" alt="">
            <div class="card-body">
              <p>&nbsp;</p><p>&nbsp;</p>
              <a onclick="location.href='${pageContext.request.contextPath}/${uvo.id}'"><h4 class="card-title">카테고리</h4></a>
              <p>&nbsp;</p>
       		  <c:choose>
       		  	<c:when test="${empty categoryList}">
	       		  <h6 class="card-subtitle mb-2 text-muted">등록된 카테고리가 없습니다.</h6>
	              <p class="card-text">카테고리를 등록하세요!</p>
       		  	</c:when>
       		  	<c:otherwise>
	              <c:forEach items="${categoryList }" var="list" varStatus="status">
	              	<h6 class="card-subtitle mb-2 text-muted">
	              		<a onclick="location.href='${pageContext.request.contextPath}/${uvo.id}?cNo=${list.no}';" style="cursor: pointer;" >-&nbsp;${list.name}</a>
	              	</h6>
	              </c:forEach>
            	</c:otherwise>
              </c:choose>
              <p>&nbsp;</p><p>&nbsp;</p>
            </div>
            <div class="card-footer">
              <a href="#" >BlogReadMale</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

      <!-- 포스트 리스트 -->
     
      <h2>포스트 목록</h2>
      <div class="row">
          <c:choose>
	      	  <c:when test="${empty userPostList}">
        		<div class="col-lg-2 col-sm-4 mb-4">
			      <h1 class="mt-4 mb-3">
			        <small>등록된 포스트가 없습니다.</small>
			      </h1>
			    </div>
		      </c:when>
		      <c:otherwise>
		          <c:forEach items="${userPostList }" var="list" varStatus="status">
		      		<div class="col-lg-2 col-sm-4 mb-4" style="border: double;">
						 <p class="card-text" >
						 	<a onclick="location.href='${pageContext.request.contextPath}/${uvo.id}?pNo=${list.no}&categoryNo=${list.category_no}';">${list.title }</a>
						 </p>
					 	<h6 class="card-subtitle mb-2 text-muted">${list.reg_date }</h6>
					</div>
				  </c:forEach>
			  </c:otherwise>
		  </c:choose>
        </div>
        
        
        <!-- 이전 페이지 처리 -->
        <nav>
		<ul class="pagination">
			<c:choose>
				<c:when test="${currPage > 1 }">
				<li><a href="?page=${currPage - 1 }"><span aria-hidden="true">◀</span><span class="sr-only">Previous</span></a></li>
				</c:when>
				<%-- <c:otherwise>
				<li>이전 페이지 없음</li>
				</c:otherwise> --%>
			</c:choose>
			
			<!-- 게시물 목록의 처리 -->
			<c:forEach begin="${navStartPage }" end="${navStartPage + navPageCount - 1}" var="pageIdx">
				<c:if test="${pageIdx <= maxPage }">
					<!-- 네비게이션의 페이지가 현재페이지이면 링크는 표시하지 않음 -->
					<c:choose>
						<c:when test="${currPage == pageIdx }">
						<li><b>${pageIdx }</b></li>
						</c:when>
						<c:otherwise>
						<li><a href="?page=${pageIdx}">${pageIdx }</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
			
			<!-- 다음 페이지 처리 -->
			<c:choose>
				<c:when test="${currPage < maxPage }">
				<li><a href="?page=${currPage + 1 }"><span aria-hidden="true">▶</span><span class="sr-only">Next</span></a></li>
				</c:when>
				<%-- <c:otherwise>
				<li>다음 페이지 없음</li>
				</c:otherwise> --%>
			</c:choose>
		</ul>
		</nav>
      </div>
      
    <!-- /.container -->

    <!-- footer -->
	<c:import url="/WEB-INF/views/includes/footer.jsp"/>


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
<script>
	$(document).on("click","#cWrite",function() {
		  var postNo = $("#postNo").html();
		  //alert(postNo);
		  if(!postNo) {
			  alert("게시글이 존재하지 않습니다!");
			  return false
		  }else {
			  /* 토글버튼 */
			  $("#commentForm").toggle("slow");
		  }
	});
	
	$(document).on("click","#cList",function() {
		  var postNo = $("#postNo").html();
		  //alert(postNo);
		  if(!postNo) {
			  alert("게시글이 존재하지 않습니다!");
			  return false
		  }else {
			  /* 토글버튼 */
			  $("#commentList").toggle("slow");
		  }
	});
 
	/* 댓글 삽입 */
	$(document).on("click","#commentWrite", function() {
	 var userName = $("#userName").html();	//태그의 value를 가져온다. 
	 var content = $("#content").val();
	 var postNo = $("#postNo").html();
	 
	// alert("userName:"+userName+" content:"+content+"postNO:"+postNo);
	 if (postNo === undefined) {
		 return false
	 }
	 $.ajax({
		 url:"${pageContext.request.contextPath}/comment/insert",
		 type:"post",
		 data:{"userName":userName,"content":content, "post_no":postNo},
		 dataType: "json",
		 success: function(result) {
			//alert("삽입성공");
			
			//alert("1:"+result.commentList[0].name);
			var temp = '';
			
	        temp += '<table class="table table-bordered">';
	        temp += '<tbody>';
	        
			for(var i=0; i<result.commentList.length; i++) {
				temp += '<tr>';
				temp += '<td id="comment_no"style="display:none">'+result.commentList[i].no+'</td>';
				temp += '<td>'+result.commentList[i].name+'</td>' 
				temp += '<td>'+result.commentList[i].content+'</td>';
				temp += '<td>'+result.commentList[i].reg_date+'</td>';
				if(result.authUser.name == result.commentList[i].name){
				temp += '<td>&nbsp;<button id="deleteBtn" class="btn btn-default">x</button></td>'
				}
				temp += '</tr>';
			}
			
			temp += '</tbody>';
			temp += '</table>';
	
			$("#commentList").html(temp); 
		 },
		 error: function(error) {
				console.err(error);
				alert("연결 실패!");
		 }
	 });	//end Ajax
	});
	
	 
	/* 댓글 삭제 */
	$(document).on("click","#deleteBtn", function() {
	 var userName = $("#userName").html();	//태그의 value를 가져온다. 
	 var content = $("#content").val();
	 var postNo = $("#postNo").html();
	 var comment_no = $("#comment_no").html();

	//alert(comment_no);
	// alert("userName:"+userName+" content:"+content+"postNO:"+postNo);
	 if (postNo === undefined) {
		 return false
	 }
	 
	 var con = confirm("정말로 삭제하시겠습니까?");
		
	 if(con == true){
		 $.ajax({
			 url:"${pageContext.request.contextPath}/comment/delete",
			 type:"post",
			 data:{"userName":userName,"content":content, "post_no":postNo, "comment_no":comment_no},
			 dataType: "json",
			 success: function(result) {
				//alert("삭제성공");
				//alert("1:"+result.commentList[0].name);
				var temp = '';
				
		        temp += '<table class="table table-bordered">';
		        temp += '<tbody>';
		        
				for(var i=0; i<result.commentList.length; i++) {
					temp += '<tr>';
					temp += '<td id="comment_no"style="display:none">'+result.commentList[i].no+'</td>';
					temp += '<td>'+result.commentList[i].name+'</td>'; 
					temp += '<td>'+result.commentList[i].content+'</td>';
					temp += '<td>'+result.commentList[i].reg_date+'</td>';
					if(result.authUser.name == result.commentList[i].name){
					temp += '<td>&nbsp;<button id="deleteBtn" class="btn btn-default">x</button></td>'
					}
					temp += '</tr>';
				}
				
				temp += '</tbody>';
				temp += '</table>';
		
				$("#commentList").html(temp); 
			 },
			 error: function(error) {
					console.err(error);
					alert("연결 실패!");
			 }
		 });	//end Ajax
	}
	else if(con_test == false){

	}
	});
</script>
</html>