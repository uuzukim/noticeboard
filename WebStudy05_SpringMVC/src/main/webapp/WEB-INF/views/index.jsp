<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<h4>${welcomeMessage }</h4>
<h4>${welcomeMessage }</h4>
<h4>현재 요청 객체 : ${pageContext.request }</h4>
<c:set var="principal"  value="${pageContext.request.userPrincipal }"/>
<c:if test="${not empty principal }">
	<c:set var="authMember" value="${principal.realUser }"/>
	<h4>${authMember.memName }님[${authMember.memRole }] 로그인 성공</h4>
	<a href="javascript:;" onclick="logoutForm.requestSubmit()">로그아웃</a>
</c:if>
<c:if test="${empty principal }">
	<a href="<c:url value='/login/loginForm.jsp'/>">로그인</a>
</c:if>
