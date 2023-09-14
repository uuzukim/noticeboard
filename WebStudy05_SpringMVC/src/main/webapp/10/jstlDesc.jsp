<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/jstlDesc.jsp</title>
<style type="text/css">
	.green{
		background-color: green;
	}
	.red{
		background-color: red;
	}
</style>
</head>
<body>
<!-- 2단~9단 승수1~9 -->
<table>
	<c:forEach var="dan" begin="2" end="9" step="2" varStatus="vs">
		<c:choose>
			<c:when test="${vs.count eq 3 }">
				<tr class="green">
			</c:when>
			<c:otherwise>
				<tr>
			</c:otherwise>
		</c:choose>
		<c:forEach var="multi" begin="1" end="9" varStatus="vsInner">
			<c:set var="clz" value="${vsInner.first or vsInner.last ? 'red' : 'other' }"/>
			<td class="${clz }">${dan} * ${multi} = ${dan*multi }</td>
		</c:forEach>
		</tr>
	</c:forEach>	
</table>

<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	custom tag : 필요에 의해 새로 작성된 태그(background module 방식).
<%-- 	<tagname attrname="attrvalue' /> --%>
<%-- 	<prefix:tagname attrname="attrvalue' /> --%>
	: custom tag library
	
	1. 커스텀 태그 로딩 : taglib(uri, prefix)
	2. 커스텀 태그 사용 : <%-- 	<prefix:tagname attrname="attrvalue' /> --%>
	 1) 속성 생성/제거 : set, remove
	 	<c:set scope="session" var="attr" value="sessionAttr" />
	 	${attr}
<%-- 	 	<c:remove var="attr" scope="session"/> --%>
	 	removed --> ${attr }
	 2) 조건문 : if, choose~when~otherwise
	 	<c:if test="${empty attr }">
	 		attr 지워졌음.
	 	</c:if>
	 	<c:if test="${not empty attr }">
	 		attr  안!!!지워졌음.
	 	</c:if>
	 	
	 	<c:choose>
	 		<c:when test="${empty attr }">
	 			attr 지워졌음.
	 		</c:when>
	 		<c:otherwise>
	 			attr  안!!!지워졌음.
	 		</c:otherwise>
	 	</c:choose>
	 3) 반복문 : forEach, forTokens
	 	for : 일반for(선언절;조건절;증감절), 향상된for(블럭변수 선언절:반복대상 컬렉션)
	 	<c:forEach var="i" begin="1" end="10" step="2">
	 		${i }
	 	</c:forEach>
	 	<c:set var="array" value='<%=new String[]{"value1", "value2"} %>'/>
	 	<c:forEach items="${array }" var="element">
	 		${element }
	 	</c:forEach>
	 	
	 	int i = 4;
	 	inti=4;
	 	SELECT * FROM MEMBER
	 	SELECT *FROM MEMBER
	 	<c:forTokens items="SELECT *FROM MEMBER" delims=" " var="token">
	 		${token }
	 	</c:forTokens>
	 	<c:forTokens items="100,2000,31000,14320" delims="," var="token">
	 		${token * 10 }
	 	</c:forTokens>
	 4) URL 재작성 : url
	 	<a href="${pageContext.request.contextPath }/member/memberInsert.do?param1=value2&param2=value2">회원가입</a>
	 	<c:url value="/member/memberInsert.do" var="insertURL">
	 		<c:param name="param1" value="value1" />
	 		<c:param name="param2" value="value2" />
	 	</c:url>
	 	<a href="${insertURL }">회원가입</a>
</pre>
</body>
</html>




















