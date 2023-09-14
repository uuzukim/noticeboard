<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<table class="table table-bordered">
	<thead class="table-light">
		<tr>
			<th><spring:message code="rnum"/></th>
			<th><spring:message code="freeboard.boTitle"/></th>
			<th><spring:message code="freeboard.boWriter"/></th>
			<th><spring:message code="freeboard.boDate"/></th>
			<th><spring:message code="freeboard.boHit"/></th>
		</tr>
	</thead>
	<tbody>
		<c:set var="boardList" value="${paging.dataList }" />
		<c:choose>
			<c:when test="${empty boardList }">
				<tr>
					<td colspan="5">조건에 맞는 게시글 없음.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${boardList }" var="board">
					<tr>
						<c:url value="/board/boardView.do" var="viewURL">
							<c:param name="what" value="${board.boNo }" />
						</c:url>
						<td>${board.rnum }</td>
						<td><a href="${viewURL }">${board.boTitle }</a></td>
						<td>${board.boWriter }</td>
						<td>${board.boDate }</td>
						<td>${board.boHit }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<div class="d-flex justify-content-center mb-3">
				${paging.pagingHTML }
				</div>
				<div id="searchUI" class="row justify-content-center">
					<div  class="col-auto">
						<form:select path="simpleCondition.searchType" class="form-select">
							<form:option value="" label="전체" />
							<form:option value="writer" label="작성자" />
							<form:option value="title" label="제목" />
							<form:option value="content" label="내용" />
						</form:select>
					</div>
					<div  class="col-auto">
						<form:input path="simpleCondition.searchWord" class="form-control"/>
					</div>
					<div  class="col-auto">
						<input type="button" value="검색" id="searchBtn" class="btn btn-success"/>
						<a href="<c:url value='/board/boardInsert.do'/>" class="btn btn-primary">새글쓰기</a>
					</div>
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
<script>
	function fn_paging(page){
		searchForm.page.value = page;
		searchForm.requestSubmit();
	}
	$(searchBtn).on("click", function(event){
		$(searchUI).find(":input[name]").each(function(idx, input){
			let name = input.name;
			let value = $(input).val();
			$(searchForm).find(`[name=\${name}]`).val(value);
		});
		$(searchForm).submit();
	});
</script>




















