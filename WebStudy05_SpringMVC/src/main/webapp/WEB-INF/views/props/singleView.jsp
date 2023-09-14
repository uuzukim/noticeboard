<%@page import="kr.or.ddit.vo.PropertyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<PropertyVO> propList = (List) request.getAttribute("propList");
%>
<table>
	<thead>
		<tr>
			<th>프로퍼티이름</th>
			<th>프로퍼티값</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(propList.isEmpty()){
				%>
				<tr>
					<td colspan="2">프로퍼티 없음.</td>
				</tr>
				<%
			}else{
				for(PropertyVO  prop : propList){
					%>
					<tr>
						<td><%=prop.getPropertyName() %></td>
						<td><%=prop.getPropertyValue() %></td>
					</tr>
					<%
				}
			}
		%>
	</tbody>
</table>























