package com.study.service;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberService {
	//회원가입
	public boolean register(MemberDTO register);
	
	//로그인
	public AuthDTO login(String userid,String password);
	//업데이트
	public boolean update(ChangeDTO changePwd);
	
	//회원탈퇴
	public boolean delete(String userid,String password);
	
	public String dupId(String userid);
}
