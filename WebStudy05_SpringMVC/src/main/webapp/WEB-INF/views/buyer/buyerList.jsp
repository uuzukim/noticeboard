<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<a href="<c:url value='/buyer/buyerInsert.do'/>" class="btn btn-primary">거래처등록</a>  
<table class="table table-border">
	<thead>
		<tr>
			<th>거래처명</th>
			<th>분류명</th>
			<th>지역</th>
			<th>연락처</th>
			<th>담당자명</th>
<!-- 			<th>거래상품수(?)</th> -->
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty buyerList }">
			<tr>
				<td colspan="6">거래처 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty buyerList }">
			<c:forEach items="${buyerList }" var="buyer">
				<c:url value="/buyer/buyerView.do" var="viewURL">
					<c:param name="what" value="${buyer.buyerId }" />
				</c:url>
				<tr>
					<td><a href="${viewURL }">${buyer.buyerName }</a></td>
					<td>${buyer.lprod.lprodNm }</td>
					<td>${buyer.buyerAdd1 }</td>
					<td>${buyer.buyerComtel }</td>
					<td>${buyer.buyerCharger }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>