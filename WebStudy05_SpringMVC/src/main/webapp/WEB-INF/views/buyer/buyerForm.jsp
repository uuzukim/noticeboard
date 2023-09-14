<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<form:form method="post" modelAttribute="buyer">
	<form:hidden path="buyerId"/>
	<table class="table table-border">
		<tr>
			<th>거래처명</th>
			<td>
				<form:input path="buyerName" class="form-control" />
				<form:errors path="buyerName" class="error" />
			</td>
		</tr>
		<tr>
			<th>거래처분류</th>
			<td>
				<form:select path="buyerLgu" class="form-select">
					<form:option value="" label="분류선택" />
					<form:options items="${lprodList }" itemLabel="lprodNm" itemValue="lprodGu"/>
				</form:select>
				<form:errors path="buyerLgu" class="error" />
			</td>
		</tr>
		<tr>
			<th>은행</th>
			<td>
				<form:input path="buyerBank" class="form-control" />
				<form:errors path="buyerBank" class="error" />
			</td>
		</tr>
		<tr>
			<th>계좌</th>
			<td>
				<form:input path="buyerBankno" class="form-control" />
				<form:errors path="buyerBankno" class="error" />
			</td>
		</tr>
		<tr>
			<th>계좌주</th>
			<td>
				<form:input path="buyerBankname" class="form-control" />
				<form:errors path="buyerBankname" class="error" />
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<form:input path="buyerZip" class="form-control" />
				<form:errors path="buyerZip" class="error" />
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<form:input path="buyerAdd1" class="form-control" />
				<form:errors path="buyerAdd1" class="error" />
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<form:input path="buyerAdd2" class="form-control" />
				<form:errors path="buyerAdd2" class="error" />
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
				<form:input path="buyerComtel" class="form-control" />
				<form:errors path="buyerComtel" class="error" />
			</td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td>
				<form:input path="buyerFax" class="form-control" />
				<form:errors path="buyerFax" class="error" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input path="buyerMail" class="form-control" />
				<form:errors path="buyerMail" class="error" />
			</td>
		</tr>
		<tr>
			<th>담당자명</th>
			<td>
				<form:input path="buyerCharger" class="form-control" />
				<form:errors path="buyerCharger" class="error" />
			</td>
		</tr>
		<tr>
			<th>내선번호</th>
			<td>
				<form:input path="buyerTelext" class="form-control" />
				<form:errors path="buyerTelext" class="error" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="btn btn-success" type="submit" value="등록">
				<input class="btn btn-danger" type="reset" value="취소">
				<input class="btn btn-secondary" type="button" value="뒤로가기"
					onclick="history.back();"
				>
				<a class="btn btn-secondary" href="<c:url value='/buyer/buyerList.do'/>">목록으로</a>
			</td>
		</tr>
	</table>
</form:form>
