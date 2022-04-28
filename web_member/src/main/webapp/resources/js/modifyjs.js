/*register.html 폼 유효성 검증을 하려고 한다
 * jquery validatiom plug-in 사용
 */
$(function () {
  $("#changePwd").validate({
    //rules 정하기 -  유효성 검증 규칙 지정
    //폼 요소 이름 사용
    rules: {
      password: {
        required: true,
        validPwd: true,
      },
      confirm_password: { required: true,validPwd: true, equalTo: "#password" }, //현재 요소가 어떤 요소랑 값이 같아야 하는가? (여기선 아이디를 써야하기때문에 #을 붙여준거임)
      new_password: { required: true, validPwd: true, }, //현재 요소가 어떤 요소랑 값이 같아야 하는가? (여기선 아이디를 써야하기때문에 #을 붙여준거임)
     
   
    }, //rules 종료
    //규칙이 맞지 않을 경우 보여줄 메세지 작성
    messages: {
     
     
      password: {
        required: "비밀번호는 필수 입력 요소입니다.",
        
      }, //현재 요소가 어떤 요소랑 값이 같아야 하는가? (여기선 아이디를 써야하기때문에 #을 붙여준거임)
     
      new_password: {
        required: "비밀번호는 필수 입력 요소입니다."
    
      }, //현재 요소가 어떤 요소랑 값이 같아야 하는가? (여기선 아이디를 써야하기때문에 #을 붙여준거임)
     
      confirm_password: {
        required: "비밀번호는 필수 입력 요소입니다.",
        equalTo: "이전 비밀번호와 다릅니다",
      }, //현재 요소가 어떤 요소랑 값이 같아야 하는가? (여기선 아이디를 써야하기때문에 #을 붙여준거임)
     
    
    
    },
    
    errorPlacement:function(error,element){
	$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
	
}
 }); 
});

$.validator.addMethod(
  "validId", //이 이름으로 펑션을 지정한거다
  function (data) {
    const regId = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,12}$/;
    return regId.test(data);
  },
  "아이디는 영문자, 숫자의 조합으로 6~12자리로 만들어야 합니다"
);
$.validator.addMethod(
  "validPwd", //이 이름으로 펑션을 지정한거다
  function (data) {
    const regPwd =
      /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{6,12}$/;
    return regPwd.test(data);
  },
  "비밀번호는 영문자, 숫자, 특수문자의 조합으로 8~15자리로 만들어야 합니다"
);
