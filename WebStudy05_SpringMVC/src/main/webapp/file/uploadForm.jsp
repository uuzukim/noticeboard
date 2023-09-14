<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/file/uploadCase1" method="post" enctype="multipart/form-data">
	<input type="text" name="uploader" placeholder="uploader"/>
	<input type="file" name="uploadFile" />
	<input type="file" name="uploadFile" />
	<input type="file" name="uploadFile" />
	<button type="submit">업로드</button>
</form>
</body>
</html>