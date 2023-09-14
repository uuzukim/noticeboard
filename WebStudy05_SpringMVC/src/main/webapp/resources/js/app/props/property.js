/**
 * 
 */
$(function(){
	let fn_modifyListBody = function(resp){
		let propList = resp.propList;
		let trTags = null;
		if(propList.length > 0){
			trTags = [];
			$.each(propList, function(index, prop){
				let tr = $("<tr>").append(
					$("<td>").html(prop.propertyName),
					$("<td>").html(prop.propertyValue),
					$("<td>").html(prop.description),
					$("<td>").html(
						$("<button type='button'>")
							.addClass("delBtn")
							.text("삭제")
					)
				).addClass("datatr")
				.prop("id", prop.propertyName)
				.data("source", prop);
				trTags.push(tr);
			});
		}else{
			trTags = `<tr><td colspan="4">프로퍼티 없음.</td></tr>`;
		}
		$(listBody).html(trTags);
	}
	
	$.getJSON(location.href)
		.done(fn_modifyListBody);	
	
	$(searchForm).on("submit", function(event){
		event.preventDefault();
		let what = this.propertyName.value;
		$.getJSON("?what="+what)
			.done(resp=>{
				resp.propList = [];
				resp.propList.push(resp.prop);
				
				fn_modifyListBody(resp);
			});
	});
		
	$(listBody).on("click", "tr.datatr" ,function(event){
		let prop = $(this).data("source");
		// console.log(prop);
		// 상세 조회용 새로운 요청 발생
		searchForm.propertyName.value = prop.propertyName;
		// $(searchForm).submit();
		searchForm.requestSubmit();
	}).on("click", ".delBtn" ,function(event){
		event.stopPropagation();
		let prop = $(this).parents("tr.datatr").data("source");
		
		let settings = {
			url:location.href,
			method:"delete",
			data:JSON.stringify( {
				propertyName : prop.propertyName
			} ),
			contentType:"application/json",
			dataType : "json"
		};
		$.ajax(settings)
			.done(resp=>{
				let propertyName = resp.result.prop.propertyName;
				if(resp.result.success){
					$(`#${propertyName}`).remove();
				}else{
					alert(`${propertyName} 삭제 실패`);
				}
			});
	});
	let $insertForm = $(insertForm).on("submit", function(event){
		event.preventDefault();
		let settings = {
			url:insertForm.action,
			method:insertForm.method,
			data: JSON.stringify($insertForm.serializeObject()),
			contentType:"application/json;charset=UTF-8",
			dataType:"json"
		};
		$.ajax(settings)
			.done(resp=>{
				if(resp.propList){
					fn_modifyListBody(resp);
					insertForm.reset();
				}else{
					alert(`${resp.result.prop} 등록 실패`);
				}
			});
	});
});






















