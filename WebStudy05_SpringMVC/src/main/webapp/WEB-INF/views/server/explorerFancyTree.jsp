<%@page import="kr.or.ddit.servlet05.fancytree.FancyTreeNodeFileAdapter"%>
<%@page import="kr.or.ddit.servlet05.FileAdapter"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="//cdn.jsdelivr.net/npm/jquery.fancytree@2.27/dist/skin-win8/ui.fancytree.min.css" rel="stylesheet">
<script src="//cdn.jsdelivr.net/npm/jquery.fancytree@2.27/dist/jquery.fancytree-all-deps.min.js"></script>

<h4 id="fileInfoArea" class="mt-3">&nbsp;</h4>
<ul id="explorer"></ul>

<script>
$(function(){
	$(explorer).fancytree({
		source: {
		   url: location.href,
		   dataType:"json" 
	    },
		lazyLoad: function(event, data) {
	      var node = data.node;
	      // Issue an Ajax request to load child nodes
	      data.result = {
	        url: location.href,
	        data: {target: node.getKeyPath()}
	      }
	    },
	    postProcess: function(event, data) {
    	  data.result = data.response.listFiles;
    	},
    	click: function(event, data) {
    		fileInfoArea.innerHTML = "&nbsp;";
    	    let node = data.node
    	 	if(!node.folder){
    	 		let settings = {
   	 				url : "<%=request.getContextPath() %>/server/fileInfo",
   	 				dataType : "json", // Accept:application/json / Content-Type,
   	 				data : {
   	 					target : node.getKeyPath()
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
    	 	}  
    	}
	});
});
</script>



















