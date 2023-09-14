<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-border">
	<tr>
		<th>회원아이디</th>
		<td>${member.memId }</td>
	</tr>
	<tr>
		<th>회원명</th>
		<td>${member.memName }</td>
	</tr>
	<tr>
		<th>프로필</th>
		<td>
			<img src="data:image/*;base64,${member.base64Img }" />
		</td>
	</tr>
	<tr>
		<th>주민번호1</th>
		<td>${member.memRegno1 }</td>
	</tr>
	<tr>
		<th>주민번호2</th>
		<td>${member.memRegno2 }</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${member.memBir }</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${member.memZip }</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${member.memAdd1 }</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${member.memAdd2 }</td>
	</tr>
	<tr>
		<th>집전번</th>
		<td>${member.memHometel }</td>
	</tr>
	<tr>
		<th>회사전번</th>
		<td>${member.memComtel }</td>
	</tr>
	<tr>
		<th>휴대폰</th>
		<td>${member.memHp }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${member.memMail }</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${member.memJob }</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>${member.memLike }</td>
	</tr>
	<tr>
		<th>기념일</th>
		<td>${member.memMemorial }</td>
	</tr>
	<tr>
		<th>기념일자</th>
		<td>${member.memMemorialday }</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${member.memMileage }</td>
	</tr>
	<tr>
		<th>탈퇴여부</th>
		<td>${member.memDelete }</td>
	</tr>
	<c:set var="prodList" value="${member.prodList }" />
	<c:if test="${not empty member.prodList }">
		<tr>
			<th>구매내역</th>
			<td>
				<table class="table table-border">
					<thead>
						<tr>
							<th>구매상품명</th>
							<th>분류명</th>
							<th>판매가</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prodList }" var="prod">
							<c:url value="/prod/prodView.do" var="viewURL">
								<c:param name="what" value="${prod.prodId }" />
							</c:url>
							<tr>
								<td><a href="${viewURL }">${prod.prodName }</a></td>
								<td>${prod.lprod.lprodNm }</td>
								<td>${prod.prodPrice }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="2">
			<button type="button" id="updateBtn" onclick="location.href='<c:url value="/member/memberUpdate.do"/>';">수정</button>
			<a class="btn btn-primary" href="<c:url value='/member/memberUpdate.do'/>">수정</a>
			<button type="button" id="deleteBtn" data-bs-toggle="modal" data-bs-target="#exampleModal">탈퇴</button>
			<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">탈퇴</a>
		</td>
	</tr>
</table>

<!-- Modal -->
<div class="modal fade" data-url="${viewURL }" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
        <form method="post" action="<c:url value='/member/memberDelete.do'/>">
	      <div class="modal-body">
	        	<input type="password" name="password" />
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-danger">탈퇴</button>
	      </div>
        </form>
    </div>
  </div>
</div>











