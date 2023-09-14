<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<table class="table table-border">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>생일</th>
			<th>거주지역(add1)</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="memberList" value="${paging.dataList }" />
	<c:if test="${empty memberList }">
		<tr>
			<td colspan="7">등록된 회원 없음.</td>
		</tr>
	</c:if>
	<c:if test="${not empty memberList }">
		<c:forEach items="${memberList }" var="member">
			<tr>
				<td>${member.rnum }</td>
				<td>${member.memId }</td>
				<td><a href="javascript:;" data-who="${member.memId }" data-bs-toggle="modal" data-bs-target="#exampleModal">${member.memName }</a></td>
				<td>${member.memHp }</td>
				<td>${member.memMail }</td>
				<td>${member.memBir }</td>
				<td>${member.memAdd1 }</td>
				<td>${member.memMileage }</td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				${paging.pagingHTML }
				<div id="searchUI">
					<form:select path="simpleCondition.searchType">
						<form:option value="" label="전체" />
						<form:option value="name" label="이름" />
						<form:option value="address" label="지역" />
					</form:select>
					<form:input path="simpleCondition.searchWord" />
					<input type="button" value="검색" id="searchBtn"/>
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
	<form:hidden path="searchType" />
	<form:hidden path="searchWord" />
	<input type="hidden" name="page" />
</form:form>

<c:url value="/member/memberView.do" var="viewURL" />

<!-- Modal -->
<div class="modal fade" data-url="${viewURL }" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src="<c:url value='/resources/js/app/member/memberList.js' />"></script>





























