/**
 * 
 */

$(exampleModal).on('show.bs.modal', event => {
	let url = event.relatedTarget.dataset.url;
	let label = event.relatedTarget.dataset.label;
	let classValue = event.relatedTarget.dataset.classValue;
	let $form = $(event.target).find("form:first");
	$form.attr("action", url);
	let $submitBtn = $(event.target).find('[type="submit"]');
	$submitBtn.attr("class", "");
	$submitBtn.addClass(classValue);
	$submitBtn.text(label);
}).on("hidden.bs.modal", event=>{
	$(event.target).find("form:first").attr("action", "");
});