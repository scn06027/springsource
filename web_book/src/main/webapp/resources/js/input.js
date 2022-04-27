/**
 *  insert.jsp 유효성
 */
$(function(){
	$(".btn-primary").click(function(e){
	//입력 버튼이 클릭되면 submit 기능 중지	
		e.preventDefault();
	//code,price 요소 가져오기
		let code=$('#code');
		let price=$('#price');
		
		//사용자 입력값 가져오고나서 숫자로 들어왔는지 확인
		if(!/^[0-9]{4}$/.test(code.val())){
			alert('코드 확인해주세요');
			code.select(); //코드 요소 안에 있는 값을 블록으로 선탤해준ㅇ다
			//숫자가 아니면? 메세지 띄우고 되돌아가라	
			return;
		}
		
			if(!/^[0-9]+$/.test(price.val())){
			alert('가격을 확인해주세요');
			price.select(); //코드 요소 안에 있는 값을 블록으로 선탤해준ㅇ다
			return;
		}
	
	
	//똑바로 됐다면 돌아가기
		$("form").submit();
		
	})
	
	
})