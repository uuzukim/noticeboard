<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty fileGroup.detailList }">
	<c:forEach items="${fileGroup.detailList }" var="fileDetail">
		<div>${fileDetail }</div>
	</c:forEach>
</c:if>