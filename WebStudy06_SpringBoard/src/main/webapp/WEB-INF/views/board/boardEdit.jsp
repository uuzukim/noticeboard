<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath }/resources/js/ckeditor/ckeditor.js"></script>
<form:form modelAttribute="targetBoard" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
	<form:hidden path="boNo"/>
	<tr>
		<th><spring:message code="freeboard.boTitle"/></th>
		<td>
			<form:input path="boTitle" class="form-control"  readonly="true"/>
			<form:errors path="boTitle" class="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boWriter" /></th>
		<td>
			<form:input path="boWriter" class="form-control" readonly="true" />
			<form:errors path="boWriter" class="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boIp" /></th>
		<td>
			<form:hidden path="boIp" class="form-control" value="${pageContext.request.remoteAddr }"/>
			${pageContext.request.remoteAddr }
			<form:errors path="boIp" class="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boMail" /></th>
		<td>
			<form:input path="boMail" class="form-control" type="email"/>
			<form:errors path="boMail" class="error" />
		</td>
	</tr>
	<tr>
		<th>기존 첨부파일</th>
		<td>
			<c:if test="${not empty targetBoard.fileGroup and not empty targetBoard.fileGroup.detailList }">
				<c:forEach items="${targetBoard.fileGroup.detailList }" var="fileDetail">
					<span data-atch-file-id="${fileDetail.atchFileId }" data-file-sn="${fileDetail.fileSn }">
						${fileDetail.orignlFileNm }<span class="btn btn-danger fileDelBtn">삭제</span>
					</span>
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			<input type="file" name="boFiles" multiple />
			<input type="file" name="boFiles" multiple />
			<input type="file" name="boFiles" multiple />
		</td>
	</tr>
	<tr>
		<th><spring:message code="freeboard.boContent" /></th>
		<td>
			<form:textarea path="boContent" class="form-control" />
			<form:errors path="boContent" class="error" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="등록" class="btn btn-success"/>
			<input type="reset" value="취소" class="btn btn-danger"/>
		</td>
	</tr>
</table>
</form:form>
<script src="<c:url value='/resources/js/app/board/boardEdit.js'/>"></script>
<script>
	
</script>














