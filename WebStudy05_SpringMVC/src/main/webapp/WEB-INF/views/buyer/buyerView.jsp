<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:url value='/buyer/buyerUpdate.do' var="updateURL">
	<c:param name="what" value="${buyer.buyerId }" />
</c:url>
<a href="${updateURL }" class="btn btn-primary">거래처 수정</a>  
<input class="btn btn-secondary" type="button" value="뒤로가기"
	onclick="history.back();"
>
<a class="btn btn-secondary" href="<c:url value='/buyer/buyerList.do'/>">목록으로</a>
<table class="table table-border">
	<tr>
		<th>거래처명</th>
		<td>${buyer.buyerName }</td>
	</tr>
	<tr>
		<th>거래처분류</th>
		<td>${buyer.lprod.lprodNm }</td>
	</tr>
	<tr>
		<th>은행</th>
		<td>${buyer.buyerBank }</td>
	</tr>
	<tr>
		<th>계좌</th>
		<td>${buyer.buyerBankno }</td>
	</tr>
	<tr>
		<th>계좌주</th>
		<td>${buyer.buyerBankname }</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${buyer.buyerZip }</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${buyer.buyerAdd1 }</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${buyer.buyerAdd2 }</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${buyer.buyerComtel }</td>
	</tr>
	<tr>
		<th>팩스번호</th>
		<td>${buyer.buyerFax }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${buyer.buyerMail }</td>
	</tr>
	<tr>
		<th>담당자명</th>
		<td>${buyer.buyerCharger }</td>
	</tr>
	<tr>
		<th>내선번호</th>
		<td>${buyer.buyerTelext }</td>
	</tr>
	<tr>
		<th>거래상품목록</th>
		<td>	
			<table class="table table-border">
				<thead>
					<tr>
						<th>상품명</th>
						<th>구매가</th>
						<th>판매가</th>
						<th>마일리지</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="prodList" value="${buyer.prodList }" />
					<c:if test="${empty prodList }">
						<tr>
							<td colspan="4">거래물품 없음.</td>
						</tr>
					</c:if>
					<c:if test="${not empty prodList }">
						<c:forEach items="${prodList }" var="prod">
							<c:url value="/prod/prodView.do" var="viewURL">
								<c:param name="what" value="${prod.prodId }" />
							</c:url>
							<tr>
								<td><a href="${viewURL }">${prod.prodName }</a></td>
								<td>${prod.prodCost }</td>
								<td>${prod.prodPrice }</td>
								<td>${prod.prodMileage }</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</td>
	</tr>
</table>




















