<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap w-100 p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="<c:url value='/'/>">Class403</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <ul class="nav px-3 col">
  	<security:authorize url="/board/boardList.do">
	    <li class="nav-item text-nowrap">
	      <a class="nav-link text-white" href="${pageContext.request.contextPath }/board/boardList.do">
	      	<spring:message code="board" />
	      </a>
	    </li>
    </security:authorize>
    <li class="nav-item text-nowrap">
      <a class="nav-link text-white" href="?lang=ko">
      	한글
      </a>
    </li>
    <li class="nav-item text-nowrap">
      <a class="nav-link text-white" href="?lang=en">
      	영어
      </a>
    </li>
  </ul>
  <ul class="nav px-3 col-2">
<!--   	조건문으로 인증 여/부에 따라 선택적 랜더링. -->
	<security:authorize access="isAuthenticated()">
		<li class="nav-item text-nowrap">
			<a class="nav-link text-white" href="<c:url value='/mypage'/>">mypage</a>
		</li>
		<li class="nav-item text-nowrap">
	    	<form id="logoutForm" method="post" action="<%=request.getContextPath() %>/login/logout"></form>
	        <a class="nav-link text-white" href="javascript:logoutForm.submit();">Sign out</a>
	    </li>
	</security:authorize>
	<security:authorize access="isAnonymous()">
		<li class="nav-item text-nowrap">
	      <a class="nav-link text-white" href="<%=request.getContextPath() %>/login/loginForm.jsp">Sign in</a>
	    </li>
	</security:authorize>
  </ul>
</nav>




























