// JavaScript Document

$('document').ready(function(e) {	
	
	$('#conDetNext').click(function(){
		company.subBase();	
		window.location.href="comInput.html#personRegisterDetTooPage";
	});
	
	$('#conDet').click(function(){
		company.subDet();	
		//window.location.href="comInput.html#personRegisterDetTooPage";
	});
});