<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/fileupload/upload">
		<label for="file1">업로드할 파일</label>
		<input type="file" name="file1"/>
		<input type="submit" value="전송">
	</form>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>File API (simple)</title>
<article>
  <p id="status">File API & FileReader API not supported</p>
  <p><input type=file></p>
  <p>Select an image from your machine to read the contents of the file without using a server</p>
  <div id="holder"></div>
</article>
<script>
var upload = document.getElementsByTagName('input')[0],
    holder = document.getElementById('holder'),
    state = document.getElementById('status');

if (typeof window.FileReader === 'undefined') {
  state.className = 'fail';
} else {
  state.className = 'success';
  state.innerHTML = 'File API & FileReader available';
}
 
upload.onchange = function (e) {
  e.preventDefault();

  var file = upload.files[0],
      reader = new FileReader();
  reader.onload = function (event) {
    var img = new Image();
    img.src = event.target.result;
    // note: no onload required since we've got the dataurl...I think! :)
    if (img.width > 560) { // holder width
      img.width = 560;
    }
    holder.innerHTML = '';
    holder.appendChild(img);
  };
  reader.readAsDataURL(file);

  return false;
};
</script>