/**
 * list script
 */

$(function(){
	//컨트롤러들어가는 스크립트(regBtn)
	$("#regBtn").click(function(){
		//버튼클릭하면 register로 이동시키기
		location.href="/board/register";
	})
	//게시물 등록 시 모달창 띄우기
	checkModal(result); //글쓰고오면 얘가 젤 먼저 실행됨
	
	history.replaceState({},null,null);
	//기존에 갖고있던 값들을 null로 만들어주는거구나
	
	function checkModal(result){
		if(result==''||history.state){ //state가돌아가지않는다면
			return; //history를 가져오지않았을때 리턴을 해줘라!
		}
		if(parseInt(result)>0){
			$(".modal-body").html("게시물 "+result+" 번이 등록되었습니다!.");
		}
		$("#myModal").modal("show"); //숨기고 싶으면 hide 해주면 됨
	}//modal 종료
	
	//페이지 이동 버튼 클릭
	let actionForm=$("#actionForm");
	$(".pagination a").click(function(e){
		e.preventDefault();//a가는거 못가게 막기
		//사용자가 선택한 페이지 번호 가져오기
		let pageNum=$(this).attr('href');
		//a를 이미 가져와서 href가 된거같음
		//가져온 번호를 actionForm 안의 pageNum으로 대체한다!.
		//find로 찾아낸 다음에 내가 위에서 가져온걸로 대신해주면 된다
		actionForm.find("[name='pageNum']").val(pageNum);
		//actionForm 보내기
		actionForm.submit();
		
	})
	//페이지 목록 개수 클릭?
	$(".form-control").change(function(e){
		e.preventDefault();
		//actionForm 안의 amount값을 변경
		actionForm.find("[name='amount']").val($(this).val());
		
		//actionForm 보내기
		actionForm.submit();
	})
	
	
})