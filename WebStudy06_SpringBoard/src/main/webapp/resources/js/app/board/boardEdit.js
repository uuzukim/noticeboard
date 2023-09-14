/**
 * 
 */

CKEDITOR.replace('boContent', {
    filebrowserImageUploadUrl: `${CPATH}/board/uploadImage.do`,
});
$(".fileDelBtn").on("click", function(){
	let $fileSpan = $(this).parent("span:first");
	let atchFileId = $fileSpan.data("atchFileId");
	let fileSn = $fileSpan.data("fileSn");
	
	$.ajax({
		url : `${CPATH}/board/fileDelete.do`
		, method : "post"
		, data : {
			atchFileId : atchFileId
			, fileSn : fileSn
		}
		, dataType : "json"
		, success : function(resp){
			$fileSpan.hide();
		}
	});
});