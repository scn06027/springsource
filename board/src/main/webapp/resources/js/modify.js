/**
 *  modify.jsp 스크립트
 */

$(function(){
	let operForm=$("#operForm");
	//버튼태그로 된애들 모조리 다
	$("button").click(function(e){
		e.preventDefault();//submit 막기
		//현재 눌러진 버튼의 data-값을 가져오기.. data-는 전역속성이다.
	let oper=$(this).data("oper");
	
	if(oper=="modify"){
		operForm=$("[role='form']")	
	}else if(oper=="remove"){
		operForm.attr('action','/board/remove');
	}else if(oper=="list"){
		operForm.find("[name='bno']").remove(); //주소줄에 있는거 지워버리고 list로 보내버린다
		operForm.attr('action','/board/list');
	}
	operForm.submit();
  })
	
})