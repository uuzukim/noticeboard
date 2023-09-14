<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="prod" enctype="multipart/form-data">
<table class="table table-border">
	<tr>
		<th>상품명</th>
		<td> 
			<form:input path="prodName" class="form-control"/>
			<form:errors path="prodName" class="error" />
		</td>	
	</tr>
	<tr>
		<th>상품분류(???)</th>
		<td>
			<form:select path="prodLgu" class="form-select">
				<form:option value="" label="분류선택" />
				<form:options items="${lprodList }" itemLabel="lprodNm" itemValue="lprodGu"/>
			</form:select>
			<form:errors path="prodLgu" class="error" />
		</td>
	</tr>
	<tr>
		<th>거래처(???)</th>
		<td>
			<form:select path="prodBuyer" class="form-select">
				<form:option value="" label="거래처선택"/>
				<c:forEach items="${buyerList }" var="buyer">
					<form:option value="${buyer.buyerId }" 
							class="${buyer.buyerLgu }" label="${buyer.buyerName }" />
				</c:forEach>
			</form:select>
			<form:errors path="prodBuyer" class="error" />
		</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td>
			<form:input path="prodCost" class="form-control" type="number"/>
			<form:errors path="prodCost" class="error"/>
		</td>
	</tr>
	<tr>
		<th>판매가</th>
		<td>
			<form:input path="prodPrice" class="form-control" type="number"/>
			<form:errors path="prodPrice" class="error"/>
		</td>
	</tr>
	<tr>
		<th>세일가</th>
		<td>
			<form:input path="prodSale" class="form-control" type="number"/>
			<form:errors path="prodSale" class="error"/>
		</td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td>
			<form:input path="prodOutline" class="form-control" />
			<form:errors path="prodOutline" class="error"/>
		</td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td>
			<form:textarea path="prodDetail" class="form-control"/>
			<form:errors path="prodDetail" class="error"/>
		</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td>
			<input type="file" name="prodImage" />
			<form:errors path="prodImg" class="error"/>
		</td>
	</tr>
	<tr>
		<th>총재고</th>
		<td>
			<form:input path="prodTotalstock" class="form-control" type="number"/>
			<form:errors path="prodTotalstock" class="error"/>
		</td>
	</tr>
	<tr>
		<th>입고일</th>
		<td>
			<form:input path="prodInsdate" class="form-control" type="date"/>
			<form:errors path="prodInsdate" class="error"/>
		</td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td>
			<form:input path="prodProperstock" class="form-control" type="number"/>
			<form:errors path="prodProperstock" class="error"/>
		</td>
	</tr>
	<tr>
		<th>크기</th>
		<td>
			<form:input path="prodSize" class="form-control" />
			<form:errors path="prodSize" class="error"/>
		</td>
	</tr>
	<tr>
		<th>색상</th>
		<td>
			<form:input path="prodColor" class="form-control" />
			<form:errors path="prodColor" class="error"/>
		</td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td>
			<form:input path="prodDelivery" class="form-control" />
			<form:errors path="prodDelivery" class="error"/>
		</td>
	</tr>
	<tr>
		<th>단위</th>
		<td>
			<form:input path="prodUnit" class="form-control" />
			<form:errors path="prodUnit" class="error"/>
		</td>
	</tr>
	<tr>
		<th>입고량</th>
		<td>
			<form:input path="prodQtyin" class="form-control" type="number"/>
			<form:errors path="prodQtyin" class="error"/>
		</td>
	</tr>
	<tr>
		<th>판매량</th>
		<td>
			<form:input path="prodQtysale" class="form-control" type="number"/>
			<form:errors path="prodQtysale" class="error"/>
		</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>
			<form:input path="prodMileage" class="form-control" type="number"/>
			<form:errors path="prodMileage" class="error"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input class="btn btn-success" type="submit" value="등록">
			<input class="btn btn-danger" type="reset" value="취소">
			<input class="btn btn-secondary" type="button" value="뒤로가기"
				onclick="history.back();"
			>
			<a class="btn btn-secondary" href="<c:url value='/prod/prodList.do'/>">목록으로</a>
		</td>
	</tr>
</table>
</form:form>

<script>
	let $prodBuyer = $('[name="prodBuyer"]');
	$('[name="prodLgu"]').on("change", function(event){
		let lprodGu = $(this).val();
		if(lprodGu){
			$prodBuyer.find("option").hide();
			$prodBuyer.find(`option:first`).show();
			$prodBuyer.find(`option.\${lprodGu}`).show();
		}else{
			$prodBuyer.find("option").show();
		}
	}).trigger("change");
</script>













