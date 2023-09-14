<%@page import="kr.or.ddit.servlet05.FileAdapter"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
/* 	li.dir:hover { */
/* 		cursor: pointer; */
/* 	} */
</style>    
<%
	List<FileAdapter> listFiles = (List) request.getAttribute("listFiles");
%>
<h4><%=application.getRealPath("/") %></h4>
<ul id="explorer">
	<%
// 		Wrapper[Adapter] design pattern
	   	String contextRealPath = application.getRealPath("/");
		
		for(FileAdapter tmp  : listFiles){
			String clz = tmp.getClzValue();
			String logicalPath = tmp.getLogicalPath();
			%>
			<li class="<%=clz%>" data-target="<%=logicalPath %>" data-length="<%=tmp.length()%>" data-mime-type="<%=tmp.getMimeType()%>"><%=tmp.getName() %></li>
			<%
		}
	%>
</ul>
<div id="fileInfoArea">
	파일명 : 1.0Mb, image/jpeg
</div>
<script>
	$(explorer).on("click", "li.dir" ,function(event){
		let target = $(this).data("target");
		if(target)
			location.href="?target="+target;
		
	}).on("click", "li.file" , function(event){
		let settings = {
			url : "<%=request.getContextPath() %>/server/fileInfo",
			dataType : "json", // Accept:application/json / Content-Type,
			data : {
				target : event.target.dataset.target 
			},
			success : function(resp) {
				let fileInfo = resp.fileInfo;
				fileInfoArea.innerHTML = ` \${fileInfo.name} : \${fileInfo.fancySize} , \${fileInfo.mimeType} `;
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR)
				console.log(status)
				console.log(error)
			}
		} //request line,header,body -> response processing

		$.ajax(settings);
	}).find("li.dir").css("cursor", "pointer");
</script>



















