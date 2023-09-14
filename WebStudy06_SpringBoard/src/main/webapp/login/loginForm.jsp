<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<div class="error">
		${SPRING_SECURITY_LAST_EXCEPTION.message }
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
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
<%-- 			<security:csrfInput/> --%>
			<button type="submit">로그인</button>
		</li>
	</ul>
</form>
</body>
</html>














