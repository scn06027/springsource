package com.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;
import com.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {
	//step1 보여주는 컨트롤러 
	@Autowired
	private MemberService service;
	
	@GetMapping("/step1")
	public void step1Get() {
		log.info("step1 페이지 불러오기");
	}

	//step2 보여주는 컨트롤러
	
	@PostMapping("/step2")
	public String step2(boolean agree,RedirectAttributes rttr) {
		log.info("step2 페이지 불러오기: "+agree);
		//약관동의했다?면 step2페이지
		if(!agree) {
			//안했으면 step1 되돌려보내셈
			rttr.addFlashAttribute("check","false");
			return "redirect:/member/step1";
			
		}
		
		return "/member/step2";
	}
	
	//step2 post 요청 처리하는 컨트롤라
	//회원가입 서비스 호출
	//회원가입 성공하면 signin보여줄거임->redriect 해주셈
	@PostMapping("/regist")
	public String regist(MemberDTO dto) {
		log.info("insert 처리"+dto);
		if(dto.getPassword().equals(dto.getConfirm_password())) {
			if(service.register(dto)) {
				return "redirect:/member/signin";
			}
		}
		return "/member/step2";
	}
	
	
	@GetMapping("/signin")
	public void signin() {
		log.info("로그인폼요청");
	}
	
	//signin post 작업
	//로그인 성공시 index 보여주기
	@PostMapping("/signin")
	public String signinPost(String userid,String password,HttpSession session) {
		log.info("login요청");
		AuthDTO dto=service.login(userid, password);
		
		if(dto==null) {
			return "redirect:/member/signin";
		}
		session.setAttribute("login", dto);
		//로그인 정보를 세션에다가 담아주는 역할을 한다
		
		return "redirect:/";
		
	}
	//로그아웃 한 뒤에 index로 이동
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃 요청");
		session.invalidate();
		return "redirect:/";
	}
	
	//비밀번호 변경 폼 요청하기
	@GetMapping("/changePwd")
	public void changePwdGet() {
		log.info("비밀번호 변경 폼 요청");
	}
	
	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDto,HttpSession session,RedirectAttributes rttr) {
		log.info("비밀번호 변경 요청");
		//현재 비밀번호 확인
		AuthDTO authDto= (AuthDTO) session.getAttribute("login");
		
		changeDto.setUserid(authDto.getUserid());
		//현재 세션에 있는 userid를 changeDto에 담아주는 역할 필요하다
		
		if(service.login(changeDto.getUserid(), changeDto.getPassword())!=null) {
			service.update(changeDto);
			session.invalidate();
			return "redirect:/member/signin";
			//일치=> 비밀번호 변경, 세션해제, 로그인 폼으로 이동
		}else {
			rttr.addFlashAttribute("error","현재 비밀번호를 확인해 주세요");
			return "redirect:/member/changePwd";
		}

	}
	//회원탈퇴
	
	@GetMapping("/leave")
	public void leave() {
		log.info("leave form 불러오기");
	}
	@PostMapping("/leave")
	public String leave(String userid,@RequestParam("current_password") String password,
			HttpSession session,RedirectAttributes rttr) {
		log.info("탈퇴요청");
		if(!service.delete(userid, password)) {
			rttr.addFlashAttribute("error","현재 비밀번호를 확인해주세요");
			return "redirect:/member/delete";
		}else {
			session.invalidate();
			//세션 왜 받아주는건가 했는데 세션 값 다 지워버릴라고 있는거였음
		return "redirect:/";	
		}		
	}
	//@Controller : 컨트롤러 종료 시점에 view가 결정된다
	//			void+/member/checkId => web=inf/views/member/checkId.jsp
	//			String+ "checkId"=>web-inf/views/checkId.jsp
	
	//중복 아이디 검사
	@ResponseBody //얠 가지고 jsp찾지말라고 해주는 어노테이션.내가 리턴하는 값이 jsp가아니다~!
	@PostMapping("/checkId")
	public String checkId(String userid) {
		log.info("중복아이디 검사!"+userid);
		
		//userid1값이 있다면 중복, null이면 사용가능~!
		if(service.dupId(userid)!=null) {
			return "false";
		}
		return "true";
	}
}
