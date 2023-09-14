<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>영역별 속성 확인</h4>
<pre>
===============================
	<%=pageContext.getAttribute("pageAttr") %>
	<%=request.getAttribute("requestAttr") %>
	<%=session.getAttribute("sessionAttr") %>
	<%=application.getAttribute("applicationAttr") %>
===============================
</pre>
</body>
</html>