/**
 * read.jsp 스크립트
 */
//list 버튼 클릭하면 /board/list로 이동한다
$(function(){
	//operForm 가져오기
	let operForm=$("#operForm");
	$(":reset").click(function(){
		location.href="/board/list";
	})
	//여러개인 클래스를 걸어버리면 맨 앞에있는 애만 처리해줌 주의할것.. 적용이 안될 수도 있음
	$(".btn-default").click(function(){
		operForm.submit();
	})
})