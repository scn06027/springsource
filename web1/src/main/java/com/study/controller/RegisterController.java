package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.RegisterDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class RegisterController {
	
	//register.jsp 보여주는 컨트롤러 생성
	@GetMapping("/register")
	public void register() {
		log.info("register.jsp 호출. . .");
	}
	//register.jsp에서 post들어오는 요청 컨트롤러 생성(RegisterDTO)
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("dto") RegisterDTO regDto) {
		log.info("정보:"+regDto);
		//로그인 페이지 보여줘라
		return "redirect:/login";
	}
	
}
