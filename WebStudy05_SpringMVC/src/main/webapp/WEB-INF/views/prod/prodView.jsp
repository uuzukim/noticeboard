<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:url value='/prod/prodUpdate.do' var="updateURL">
	<c:param name="what" value="${prod.prodId }" />
</c:url>
<a href="${updateURL }" class="btn btn-primary">상품수정</a>
<input class="btn btn-secondary" type="button" value="뒤로가기"
	onclick="history.back();"
>
<a class="btn btn-secondary" href="<c:url value='/prod/prodList.do'/>">목록으로</a>
<table class="table table-border">
	<tr>
		<th>상품코드</th>
		<td>${prod.prodId }</td>
	</tr>
	<tr>
		<th>상품명</th>
		<td>${prod.prodName }</td>
	</tr>
	<tr>
		<th>상품분류</th>
		<td>${prod.prodLgu }</td>
	</tr>
	<tr>
		<th>거래처정보</th>
		<td>
			<table class="table table-border">
				<thead>
					<tr>
						<th>거래처명</th>
						<th>거래처분류명</th>
						<th>거래처소재지</th>
						<th>거래은행명</th>
						<th>거래은행계좌</th>
						<th>담당자명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:set var="buyer" value="${prod.buyer }" />
						<c:url value="/buyer/buyerView.do" var="viewURL">
							<c:param name="what" value="${buyer.buyerId }" />
						</c:url>	
						<td><a href="${viewURL }">${buyer.buyerName }</a></td>
						<td>${buyer.lprod.lprodNm }</td>
						<td>${buyer.buyerAdd1 }</td>
						<td>${buyer.buyerBank }</td>
						<td>${buyer.buyerBankno }</td>
						<td>${buyer.buyerCharger }</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td>${prod.prodCost }</td>
	</tr>
	<tr>
		<th>판매가</th>
		<td>${prod.prodPrice }</td>
	</tr>
	<tr>
		<th>세일가</th>
		<td>${prod.prodSale }</td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td>${prod.prodOutline }</td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td>${prod.prodDetail }</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><img src="<c:url value='/resources/prodImages/${prod.prodImg }'/>" /></td>
	</tr>
	<tr>
		<th>총재고</th>
		<td>${prod.prodTotalstock }</td>
	</tr>
	<tr>
		<th>입고일</th>
		<td>${prod.prodInsdate }</td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td>${prod.prodProperstock }</td>
	</tr>
	<tr>
		<th>크기</th>
		<td>${prod.prodSize }</td>
	</tr>
	<tr>
		<th>색상</th>
		<td>${prod.prodColor }</td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td>${prod.prodDelivery }</td>
	</tr>
	<tr>
		<th>단위</th>
		<td>${prod.prodUnit }</td>
	</tr>
	<tr>
		<th>입고량</th>
		<td>${prod.prodQtyin }</td>
	</tr>
	<tr>
		<th>판매량</th>
		<td>${prod.prodQtysale }</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${prod.prodMileage }</td>
	</tr>
	<c:if test="${not empty prod.memList }">
		<tr>
			<th>구매자정보</th>
			<td>
				<table class="table table-border">
					<thead>
						<tr>
							<th>구매자명</th>
							<th>이메일</th>
							<th>지역</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="memList" value="${prod.memList }" />
						<c:forEach items="${memList }" var="member">
							<tr>
								<td>${member.memName }</td>
								<td>${member.memMail }</td>
								<td>${member.memAdd1 }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</c:if>
</table>























