<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<h4>웰컴페이지</h4>
${sessionScope }
<security:authorize access="isAuthenticated()">
<div style="border: 1px solid black;">
	<security:authentication property="principal.realUser" var="authMember"/>
	${authMember.memName }
</div>
</security:authorize>
<spring:eval expression="@appInfo.permPath" var="permPath"/>
appInfo 에 등록된 permPath : ${permPath }
