/**
 * 값이 비어있으면 못들어가게 하기
 */
$(function(){
	$("[type='submit']").click(function(e){
		//일단 submit 눌러도 못가게 기능을 막아준다
		e.preventDefault();
		let form=$(".form-control");
		
		if(form.val()==""){
			alert("내용을 채워넣어주세요.");
			return;
		}
		
	})
	
	$("[type='submit']").unbind('click').click()
	
})