<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="<c:url value='/prod/prodInsert.do'/>" class="btn btn-primary">상품등록</a> 
<input class="btn btn-secondary" type="button" value="뒤로가기"
	onclick="history.back();"
>
<a class="btn btn-secondary" href="<c:url value='/prod/prodList.do'/>">목록으로</a>   
<table class="table table-border">
	<thead>
		<tr>
			<th>상품명</th>
			<th>상품분류명</th>
			<th>거래처명</th>
			<th>거래처소재지</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>입고일</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="6">조건에 맞는 상품 없음.</td>
			</tr>
		</c:if>
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<c:url value="/prod/prodView.do" var="viewURL">
					<c:param name="what" value="${prod.prodId }" />
				</c:url>
				<tr>
					<td><a href="${viewURL }">${prod.prodName }</a></td>
					<td>${prod.lprod.lprodNm }</td>
					<td>${prod.buyer.buyerName }</td>
					<td>${prod.buyer.buyerAdd1 }</td>
					<td>${prod.prodCost }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodInsdate }</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>


























