<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
	<tr>
		<th><spring:message code="freeboard.boNo" /></th>
		<td>${freeboard.boNo }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boTitle" /></th>
		<td>${freeboard.boTitle }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boWriter" /></th>
		<td>${freeboard.boWriter }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boIp" /></th>
		<td>${freeboard.boIp }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boMail" /></th>
		<td>${freeboard.boMail }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boPass" /></th>
		<td>${freeboard.boPass }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			<c:if test="${not empty freeboard.fileGroup and not empty freeboard.fileGroup.detailList }">
				<c:forEach items="${freeboard.fileGroup.detailList }" var="fileDetail">
					<c:url value="/board/download.do" var="downloadURL">
						<c:param name="atchFileId" value="${fileDetail.atchFileId }" />
						<c:param name="fileSn" value="${fileDetail.fileSn }" />
					</c:url>
					<a href="${downloadURL }">${fileDetail.orignlFileNm }</a>
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boContent" /></th>
		<td>${freeboard.boContent }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boDate" /></th>
		<td>${freeboard.boDate }</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boHit" /></th>
		<td>${freeboard.boHit }</td>
	</tr>
	<tr>
		<td>
			<a class="btn btn-primary" data-bs-toggle="modal" 
					data-bs-target="#exampleModal" 
					data-url="<c:url value='/board/updateAuth.do'/>"
					data-label="수정"
					data-class-value="btn btn-primary"
					>수정</a>
			<a class="btn btn-danger" data-bs-toggle="modal" 
					data-bs-target="#exampleModal" 
					data-url="<c:url value='/board/boardDelete.do'/>"
					data-label="삭제" 
					data-class-value="btn btn-danger"
					>삭제</a>
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
        <form method="post" action="">
	      <div class="modal-body">
	      		<input type="hidden" name="boNo" value="${freeboard.boNo }" />
	        	<input type="password" name="boPass" class="form-control" />
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="submit">전송</button>
	      </div>
        </form>
    </div>
  </div>
</div>
<script src="<c:url value='/resources/js/app/board/boardView.js'/>"></script>











