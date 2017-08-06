
$(document).ready(function(){
	var width = window.innerWidth;
	var height = window.innerHeight;
	$(".editormd-dialog").each(function(){
		toCenter(this);
	});
});

function toCenter(e){
	var width = window.innerWidth;
	var height = window.innerHeight;
	var left = width/2-$(e).innerWidth()/2;
	var top = height/2-$(e).innerHeight()/2;
	$(e).css("left",left+"px");
	$(e).css("top",top+"px");
}
