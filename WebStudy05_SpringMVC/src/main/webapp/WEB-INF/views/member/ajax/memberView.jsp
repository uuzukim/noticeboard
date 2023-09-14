<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-border">
	<tr>
		<th>회원아이디</th>
		<td>${member.memId }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.memPass }</td>
	</tr>
	<tr>
		<th>회원명</th>
		<td>${member.memName }</td>
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
</table>