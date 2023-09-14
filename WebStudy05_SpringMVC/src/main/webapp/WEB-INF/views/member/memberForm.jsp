<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="member" enctype="multipart/form-data">
	<table class="table table-border">
		<tr>
			<th>회원아이디</th>
			<td>
				<form:input path="memId" class="form-control" />
				<form:errors path="memId" class="error" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<form:password path="memPass"  class="form-control" />
				<form:errors path="memPass" class="error" />
			</td>
		</tr>
		<tr>
			<th>프로필</th>
			<td>
				<input type="file" name="memImage" />
			</td>
		</tr>
		<tr>
			<th>회원명</th>
			<td>
				<form:input path="memName" class="form-control" />
				<form:errors path="memName" class="error" />
			</td>
		</tr>
		<tr>
			<th>주민번호1</th>
			<td>
				<form:input path="memRegno1" class="form-control" />
				<form:errors path="memRegno1" class="error" />
			</td>
		</tr>
		<tr>
			<th>주민번호2</th>
			<td>
				<form:input path="memRegno2" class="form-control" />
				<form:errors path="memRegno2" class="error" />
			</td>
		</tr>
		<tr>
			<th>생일</th>
			<td>
				<form:input path="memBir" class="form-control" type="datetime-local" />
				<form:errors path="memBir" class="error" />
			</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>
				<form:input path="memZip" class="form-control" />
				<form:errors path="memZip" class="error" />
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<form:input path="memAdd1" class="form-control" />
				<form:errors path="memAdd1" class="error" />
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<form:input path="memAdd2" class="form-control" />
				<form:errors path="memAdd2" class="error" />
			</td>
		</tr>
		<tr>
			<th>집전번</th>
			<td>
				<form:input path="memHometel" class="form-control" />
				<form:errors path="memHometel" class="error" />
			</td>
		</tr>
		<tr>
			<th>회사전번</th>
			<td>
				<form:input path="memComtel" class="form-control" />
				<form:errors path="memComtel" class="error" />
			</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>
				<form:input path="memHp" class="form-control" />
				<form:errors path="memHp" class="error" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input path="memMail" class="form-control" />
				<form:errors path="memMail" class="error" />
			</td>
		</tr>
		<tr>
			<th>직업</th>
			<td>
				<form:input path="memJob" class="form-control" />
				<form:errors path="memJob" class="error" />
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<form:input path="memLike" class="form-control" />
				<form:errors path="memLike" class="error" />
			</td>
		</tr>
		<tr>
			<th>기념일</th>
			<td>
				<form:input path="memMemorial" class="form-control" />
				<form:errors path="memMemorial" class="error" />
			</td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td>
				<form:input path="memMemorialday" class="form-control" type="date" />
				<form:errors path="memMemorialday" class="error" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="btn btn-success" type="submit" value="저장"> 
				<input class="btn btn-danger" type="reset" value="취소">
			</td>
		</tr>
	</table>
</form:form>