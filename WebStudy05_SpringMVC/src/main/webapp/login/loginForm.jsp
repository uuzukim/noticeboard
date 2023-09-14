<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<c:if test="${not empty message }">
	<div class="error">
		${message }
		<c:remove var="message" scope="session"/>
	</div>
</c:if>
<form action="${pageContext.request.contextPath }/login/loginProcess" method="post">
	<ul>
		<li>
			아이디 : <input type="text" name="memId" value="${cookie.idCookie.value }"/>
			<input type="checkbox" name="idSave" ${not empty cookie.idCookie ? "checked":"" }/>아이디저장
		</li>
		<li>
			비밀번호 : <input type="text" name="memPass" />
		</li>
		<li>
			<button type="submit">로그인</button>
		</li>
	</ul>
</form>
</body>
</html>














