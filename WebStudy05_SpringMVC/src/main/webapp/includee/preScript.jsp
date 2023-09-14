<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!-- module page -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/js/bootstrap5/css/bootstrap.min.css">

<script src="<%=request.getContextPath() %>/resources/js/jquery-3.7.0.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/customLibs.js"></script>
<script>
	<c:if test="${not empty message }">
		alert("${message}");
	</c:if>

	$(document).on("ajaxError", function(jqXHR, settings, errorText){
		console.log("XMLHttpRequest : ", jqXHR);
		console.log("settings : ", settings);
		console.log("error : ", errorText);
	});
</script>