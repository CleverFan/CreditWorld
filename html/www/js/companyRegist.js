// JavaScript Document

$('document').ready(function(e) {	
	$('#trueradio').click(function(){
		 var val=$('input:radio[name="trueradio"]:checked').val();
		if(val==null){
			return false;
		}
		else{
			$('#next').css("display","block");
		}
	});
	
	$('#conBsaeNext').click(function(){
		company.regist();	
	});
});